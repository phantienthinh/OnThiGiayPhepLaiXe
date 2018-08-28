package com.onthi.laixe.onthigiaypheplaixe.activity;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.onthi.laixe.onthigiaypheplaixe.R;
import com.onthi.laixe.onthigiaypheplaixe.adapters.CheckAnswerAdapter;
import com.onthi.laixe.onthigiaypheplaixe.fragments.ScreenSlideNgauNhienDeFragment;
import com.onthi.laixe.onthigiaypheplaixe.models.Question;
import com.onthi.laixe.onthigiaypheplaixe.models.QuestionController;
import com.onthi.laixe.onthigiaypheplaixe.models.SharedPreferencesManager;
import com.onthi.laixe.onthigiaypheplaixe.widget.CountDownTimerPausable;

import java.util.ArrayList;
import java.util.Random;

public class NgauNhienActivity extends FragmentActivity implements View.OnClickListener, AdapterView.OnItemClickListener, DialogInterface.OnCancelListener {
    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    public static int NUM_PAGES = 20;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    public int checkAnswer = 0;
    private ViewPager mPager;
    private ImageView iv_hourGlass, iv_back;
    //    private Animation animator;
    private ObjectAnimator animator;
    private String i;
    private BroadcastReceiver receiver;
    private IntentFilter filter;
    private TextView tv_check, tvTimer, tv_cancel_end_test, tv_yes_end_test, tv_xem_diem;
    private Dialog dialog;
    //    private CountDownTimer timer;
    private CountDownTimerPausable timer;
    private Dialog dialog_end_test;
    private static final long timeDeThi = 20 * 60 * 1000;
    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;
    QuestionController questionController;
    ArrayList<Question> arr_questions;
    ArrayList<Question> arr_bienbao;
    ArrayList<Question> arr_sahinh;
    ArrayList<Question> arr_lythuyet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);
        receiver =new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                switch (intent.getAction()){
                    case "finish_ngaunhien":
                        finish();
                        break;
                }
            }
        };
        filter = new IntentFilter();
        filter.addAction("finish_ngaunhien");
        registerReceiver(receiver,filter);

        tv_xem_diem = findViewById(R.id.tv_Xem_diem);
        tv_xem_diem.setOnClickListener(this);
        iv_back = findViewById(R.id.iv_back);
        tvTimer = findViewById(R.id.tv_timer);
        tvTimer.setText("Ôn Tập");
        createCountTimer();
        // Instantiate a ViewPager and a PagerAdapter.
        Intent intent = getIntent();
        i = intent.getStringExtra(ChuDeActivity.KEY_INTENT_CHU_DE);


        mPager = (ViewPager) findViewById(R.id.pager);
        iv_hourGlass = findViewById(R.id.iv_hourglass);
//        iv_hourGlass.setVisibility(View.GONE);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_hourglass);
        iv_hourGlass.setAnimation(animation);
        iv_hourGlass.startAnimation(animation);

//        animator = ObjectAnimator.ofFloat(iv_hourGlass, "rotation", 0f, 360f);
//        animator.setDuration(1000);
//        animator.setRepeatCount(ValueAnimator.INFINITE);
//        animator.setInterpolator(new LinearInterpolator());
//        animator.start();

        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        questionController = new QuestionController(this);
        arr_questions = new ArrayList<>();

        arr_bienbao = new ArrayList<>();
        arr_lythuyet = new ArrayList<>();
        arr_sahinh = new ArrayList<>();
        arr_bienbao = questionController.getQuestionChuDe("BB");
        arr_sahinh = questionController.getQuestionChuDe("SH");
        arr_lythuyet = questionController.getQuestionChuDe("LT");


        for (int i = 1; i < 11; i++) {
            Random random = new Random();
            int index = random.nextInt(arr_lythuyet.size());
            arr_questions.add(arr_lythuyet.get(index));
        }
        for (int b = 1; b < 6; b++) {
            Random random = new Random();
            int position = random.nextInt(arr_bienbao.size());
            arr_questions.add(arr_bienbao.get(position));
        }
        for (int c = 1;c<6;c++){
            Random random = new Random();
            int position =random.nextInt(arr_sahinh.size());
            arr_questions.add(arr_sahinh.get(position));
        }
//        arr_questions = questionController.getRandomQuestion();

//        arr_questions.get().getImage();
        mPager.setAdapter(mPagerAdapter);
        mPager.setPageTransformer(true, new DepthPageTransformer());

        tv_check = findViewById(R.id.tv_Check);
//        tv_check.setVisibility(View.GONE);
        tv_check.setOnClickListener(this);
        iv_back.setOnClickListener(this);
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (SharedPreferencesManager.getButtonEnd(NgauNhienActivity.this) == true) {
                    sendBroadcast(new Intent("key_show_text"));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public ArrayList<Question> getData() {
        return arr_questions;
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            overridePendingTransition(R.anim.anim_start, R.anim.anim_back);
            super.onBackPressed();

        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_Check:
                checkAnswer();
                break;
            case R.id.btn_end:

                tv_xem_diem.setVisibility(View.VISIBLE);
                tv_check.setVisibility(View.GONE);
                SharedPreferencesManager.setButtonEnd(this, true);
                Log.e("daa", "onClick: ");
                dialog.cancel();
                timer.cancel();
//                tvTimer.setText("Ôn Tập");
                checkAnswer = 1;
                iv_hourGlass.clearAnimation();
//                ScreenSlidePageFragment.tv_giai_thich.setVisibility(View.VISIBLE);
//                mPagerAdapter.notifyDataSetChanged();
                sendBroadcast(new Intent("key_show_text"));
                break;
            case R.id.btn_cancel:
                dialog.cancel();
                break;
            case R.id.iv_back:
                dialog_end_test = new Dialog(this);
                dialog_end_test.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog_end_test.setContentView(R.layout.dialog_end_test);
                dialog_end_test.show();
                tv_cancel_end_test = dialog_end_test.findViewById(R.id.tv_cancel_end_test);
                tv_yes_end_test = dialog_end_test.findViewById(R.id.tv_yes_end_test);
                tv_cancel_end_test.setOnClickListener(this);
                tv_yes_end_test.setOnClickListener(this);
//                finish();
                break;
            case R.id.tv_cancel_end_test:
                dialog_end_test.cancel();
                break;
            case R.id.tv_yes_end_test:
                finish();
                break;
            case R.id.tv_Xem_diem:
//                finish();
                Intent intent = new Intent(this, ShowKQNgauNhienActivity.class);
                intent.putExtra("arr_question", arr_questions);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        mPager.setCurrentItem(i);
        dialog.cancel();
    }

    @Override
    public void onCancel(DialogInterface dialogInterface) {
        timer.start();
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_hourglass);
        iv_hourGlass.startAnimation(animation);
    }


    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return ScreenSlideNgauNhienDeFragment.create(position, checkAnswer);
        }

        @Override
        public int getCount() {
            return arr_questions.size();
        }
    }

    public class DepthPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.75f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0);

            } else if (position <= 0) { // [-1,0]
                // Use the default slide transition when moving to the left page
                view.setAlpha(1);
                view.setTranslationX(0);
                view.setScaleX(1);
                view.setScaleY(1);

            } else if (position <= 1) { // (0,1]
                // Fade the page out.
                view.setAlpha(1 - position);

                // Counteract the default slide transition
                view.setTranslationX(pageWidth * -position);

                // Scale the page down (between MIN_SCALE and 1)
                float scaleFactor = MIN_SCALE
                        + (1 - MIN_SCALE) * (1 - Math.abs(position));
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0);
            }
        }
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(receiver);
        super.onDestroy();
    }

    public void checkAnswer() {
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_answer);
        CheckAnswerAdapter answerAdapter = new CheckAnswerAdapter(arr_questions, this);
        GridView gridView = dialog.findViewById(R.id.gv_list_answer);
        gridView.setAdapter(answerAdapter);
        gridView.setOnItemClickListener(this);
        Button buttonEnd = (Button) dialog.findViewById(R.id.btn_end);
        Button buttonCancel = (Button) dialog.findViewById(R.id.btn_cancel);
        buttonCancel.setOnClickListener(this);
        buttonEnd.setOnClickListener(this);
        dialog.show();
        timer.pause();
        iv_hourGlass.clearAnimation();
        dialog.setOnCancelListener(this);
    }

    private void createCountTimer() {
//        timer = new CountDownTimer(timeDeThi,1000) {
//            @Override
//            public void onTick(long l) {
//                int seconds = (int) (l / 1000) % 60 ;
//                int minutes = (int) ((l / (1000*60)) % 60);
//                // int hours   = (int) ((l / (1000*60*60)) % 24);
//                if (seconds<10){
//                    tvTimer.setText(minutes+":0"+seconds);
//                }else {
//                    tvTimer.setText(minutes+":"+seconds);
//                }
//            }
//
//            @Override
//            public void onFinish() {
//                Toast.makeText(ScreenSlideActivity.this, "hết giò", Toast.LENGTH_SHORT).show();
//                iv_hourGlass.clearAnimation();
//            }
//        };

        timer = new CountDownTimerPausable(timeDeThi, 1000) {
            @Override
            public void onTick(long l) {
                int seconds = (int) (l / 1000) % 60;
                int minutes = (int) ((l / (1000 * 60)) % 60);
                // int hours   = (int) ((l / (1000*60*60)) % 24);
                if (seconds < 10) {
                    tvTimer.setText(minutes + ":0" + seconds);
                } else {
                    tvTimer.setText(minutes + ":" + seconds);
                }
            }

            @Override
            public void onFinish() {
                Toast.makeText(NgauNhienActivity.this, "hết giò", Toast.LENGTH_SHORT).show();
                iv_hourGlass.clearAnimation();
                tvTimer.setText("00:00");
            }
        };
        timer.start();
    }
}