package com.naild2d.android.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.naild2d.android.R;
import com.naild2d.android.activity.extend.NailD2DAsyncHandler;
import com.naild2d.android.activity.extend.NailD2DAsyncTask;
import com.naild2d.android.model.PackageScheduleInfo;
import com.naild2d.android.service.PackageService;

/**
 * Created by ebread on 2015/5/26.
 */
public class OrderDatePanelView extends LinearLayout {

    private int SCHEDULE_INDEX_TODAY = 0;
    private int SCHEDULE_INDEX_TOMORROW = 12;
    private int SCHEDULE_INDEX_AFTER_TOMORROW = 24;

    private Button todayButton = null;
    private Button tomorrowButton = null;
    private Button afterTomorrowButton = null;
    private OrderDateTableView orderDateTable = null;

    private String packageId = null;
    private PackageService packageService = null;
    private PackageScheduleInfo[] scheduleInfos = null;

    public OrderDatePanelView(Context context) {
        super(context);
    }

    public OrderDatePanelView(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.component_order_date_panel, this);

        packageService = new PackageService(context);

        todayButton = (Button) findViewById(R.id.order_date_today);
        tomorrowButton = (Button) findViewById(R.id.order_date_tomorrow);
        afterTomorrowButton = (Button) findViewById(R.id.order_date_after_tomorrow);
        orderDateTable = (OrderDateTableView) findViewById(R.id.order_date_table);

        todayButton.setOnClickListener(new DateOnClickListener());
        tomorrowButton.setOnClickListener(new DateOnClickListener());
        afterTomorrowButton.setOnClickListener(new DateOnClickListener());

        orderDateTable.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                OrderDatePanelView.this.performClick();
            }
        });

    }

    public PackageScheduleInfo getSelectedSchedule() {
        return orderDateTable.getSelectedSchedule();
    }

    public void setPackageId(int id) {
        packageId = String.valueOf(id);

        NailD2DAsyncTask.doInBackground(new NailD2DAsyncHandler() {
            @Override
            public Object doAsync(Object... params) {
                return packageService.getScheduleInfo(packageId);
            }

            @Override
            public void asyncSuccess(Object result) {
                scheduleInfos = (PackageScheduleInfo[]) result;
                initDayButton();
            }
        });
    }

    private void initDayButton() {
        setDayButtonActive(todayButton, true);
        setDayButtonActive(tomorrowButton, false);
        setDayButtonActive(afterTomorrowButton, false);
    }

    private void setDayButtonActive(Button button, boolean active) {

        button.setBackgroundResource(active ? R.drawable.bg_order_tab_item_active : R.drawable.bg_order_tab_item_normal);

        String dayText = "";
        PackageScheduleInfo[] scheduleInfos = null;
        if (button == todayButton) {
            dayText = getResources().getString(R.string.today);
            scheduleInfos = getDaySchedule(SCHEDULE_INDEX_TODAY);
        } else if (button == tomorrowButton) {
            dayText = getResources().getString(R.string.tomorrow);
            scheduleInfos = getDaySchedule(SCHEDULE_INDEX_TOMORROW);
        } else {
            dayText = getResources().getString(R.string.after_tomorrow);
            scheduleInfos = getDaySchedule(SCHEDULE_INDEX_AFTER_TOMORROW);
        }
        button.setText(dayText);

        orderDateTable.updateDateTable(scheduleInfos);
    }


    private PackageScheduleInfo[] getDaySchedule(int start) {
        PackageScheduleInfo[] result = new PackageScheduleInfo[12];
        for (int index = 0; index < 12; index++) {
            result[index] = scheduleInfos[start + index];
        }
        return result;
    }

    class DateOnClickListener implements OnClickListener {
        @Override
        public void onClick(View v) {
            setDayButtonActive(todayButton, false);
            setDayButtonActive(tomorrowButton, false);
            setDayButtonActive(afterTomorrowButton, false);
            setDayButtonActive((Button) v, true);
        }
    }


}
