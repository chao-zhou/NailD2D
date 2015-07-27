package com.naild2d.android.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.naild2d.android.R;
import com.naild2d.android.model.PackageScheduleInfo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ebread on 2015/5/26.
 */
public class OrderDateTableView extends TableLayout {

    private List<OrderDateItemView> dateItemList = new ArrayList<>();
    private PackageScheduleInfo selectedSchedule = null;

    public OrderDateTableView(Context context) {
        super(context);
    }

    public OrderDateTableView(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.component_order_date_table, this);

        initDateItemList();
    }

    public List<OrderDateItemView> getDateItemList() {
        return dateItemList;
    }

    public PackageScheduleInfo getSelectedSchedule() {
        return selectedSchedule;
    }

    public void updateDateTable(PackageScheduleInfo[] scheduleInfos) {
        int index = 0;
        for (OrderDateItemView view : dateItemList) {
            PackageScheduleInfo info = scheduleInfos[index++];
            view.setTag(info);
        }

        updateDateItemByTag();
    }

    private void updateDateItemByTag() {
        for (OrderDateItemView view : dateItemList) {
            PackageScheduleInfo info = (PackageScheduleInfo) view.getTag();
            view.setDateValue(info.getTime());
            view.setAvailable(info.isEnable());

            if (selectedSchedule != null) {
                view.setBooked(info.getId() == selectedSchedule.getId());
            }
        }
    }

    private void initDateItemList() {
        List<TableRow> rows = getTableRows();
        Iterator<TableRow> iterator = rows.iterator();
        while (iterator.hasNext()) {
            TableRow row = iterator.next();
            dateItemList.addAll(getOrderDateItemsInRow(row));
        }
    }

    private List<TableRow> getTableRows() {
        List<TableRow> rows = new ArrayList<>();
        View childView;

        TableLayout tableLayout = (TableLayout) getChildAt(0);
        for (int i = 0; i < tableLayout.getChildCount(); i++) {
            childView = tableLayout.getChildAt(i);
            if (!(childView instanceof TableRow)) {
                continue;
            }

            rows.add((TableRow) childView);
        }

        return rows;
    }

    private List<OrderDateItemView> getOrderDateItemsInRow(TableRow row) {
        List<OrderDateItemView> items = new ArrayList<>();
        View childView;

        for (int i = 0; i < row.getChildCount(); i++) {
            childView = row.getChildAt(i);
            if (!(childView instanceof OrderDateItemView)) {
                continue;
            }

            childView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedSchedule = (PackageScheduleInfo) v.getTag();
                    updateDateItemByTag();
                    OrderDateTableView.this.performClick();
                }
            });
            items.add((OrderDateItemView) childView);
        }

        return items;
    }
}
