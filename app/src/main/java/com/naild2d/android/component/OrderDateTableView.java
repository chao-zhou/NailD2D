package com.naild2d.android.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.naild2d.android.R;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ebread on 2015/5/26.
 */
public class OrderDateTableView extends TableLayout {

    private List<OrderDateItemView> dateItemList = new ArrayList<>();

    public OrderDateTableView(Context context) {
        super(context);
    }

    public OrderDateTableView(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.component_order_date_table,this);

        getDateItemList();
    }

    private void getDateItemList(){
        List<TableRow> rows = getTableRows();
        Iterator<TableRow> iterator = rows.iterator();

        while (iterator.hasNext()){
           TableRow row =  iterator.next();
            dateItemList.addAll(getOrderDateItemsInRow(row));
        }
    }

    private List<TableRow> getTableRows(){
        List<TableRow> rows = new ArrayList<>();
        View childView;

        for(int i=0;i<getChildCount();i++){
            childView = getChildAt(i);
            if(childView instanceof TableRow){
                rows.add((TableRow)childView);
            }
        }

        return rows;
    }

    private List<OrderDateItemView> getOrderDateItemsInRow(TableRow row){
        List<OrderDateItemView> items = new ArrayList<>();
        View childView;

        for(int i=0;i<row.getChildCount();i++){
            childView = row.getChildAt(i);
            if(childView instanceof OrderDateItemView){
                items.add((OrderDateItemView)childView);
            }
        }

        return items;
    }
}
