/*
 * This project is licensed under the open source MPL V2.
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */

package com.mifos.utils;


import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.mifos.objects.noncore.DataTable;

import java.util.Iterator;

/**
 * Created by ishankhanna on 17/06/14.
 * <p/>
 * This is a helper class that is used to generate a layout for
 * Data Table Fragments dynamically based on the data received.
 */
@SuppressWarnings("deprecation")
public class DataTableUIBuilder {

    int tableIndex;
    private DataTableActionListener dataTableActionListener;

    public LinearLayout getDataTableLayout(final DataTable dataTable,
                                           JsonArray jsonElements,
                                           LinearLayout parentLayout,
                                           final Context context,
                                           final int entityId,
                                           Boolean isAttribute,
                                           DataTableActionListener mListener
    ) {
        dataTableActionListener = mListener;

        /**
         * Create a Iterator with Json Elements to Iterate over the DataTable
         * Response.
         */
        Iterator<JsonElement> jsonElementIterator = jsonElements.iterator();
        /*
         * Each Row of the Data Table is Treated as a Table Here.
         * Creating the First Table for First Row
         */
        tableIndex = 0;
        while (jsonElementIterator.hasNext()) {

            final JsonElement jsonElement = jsonElementIterator.next();

            parentLayout = createCardView(dataTable, parentLayout, context, entityId, isAttribute, jsonElement);

            Log.i("TABLE INDEX", "" + tableIndex);
            tableIndex++;
        }
        return parentLayout;
    }

    private LinearLayout createCardView(final DataTable dataTable, LinearLayout parentLayout, Context context, final int entityId, Boolean isAttribute, final JsonElement jsonElement) {
        /*
         * Creating CardView
         */
        CardView cardView = new CardView(context);
        LayoutParams params = new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT
        );
        params.setMargins(8, 8, 8, 8);
        cardView.setLayoutParams(params);
        cardView.setRadius(8);
        cardView.setPadding(16, 16, 16, 16);
        cardView.setCardElevation(2);


        /*
         * Creating TableLayout
         */
        TableLayout tableLayout = new TableLayout(context);
        tableLayout.setPadding(20, 20, 20, 20);

        /*
        * Each Entry in a Data Table is Displayed in the
        * form of a table where each row contains one Key-Value Pair
        * i.e a Column Name - Column Value from the DataTable
        */
        int rowIndex = 0;
        while (rowIndex < dataTable.getColumnHeaderData().size()) {
            TableRow tableRow = new TableRow(context);
            tableRow.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams
                    .MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            tableRow.setPadding(10, 10, 10, 10);
            if (rowIndex % 2 == 0) {
                tableRow.setBackgroundColor(Color.parseColor("#ADD8E6"));
            } else {
                tableRow.setBackgroundColor(Color.WHITE);
            }

            String columnName = dataTable.getColumnHeaderData().get(rowIndex).getColumnName();
            if("id".equalsIgnoreCase(columnName) ||
              "client_id".equalsIgnoreCase(columnName) ||
              "loan_id".equalsIgnoreCase(columnName)
            ) {
                rowIndex++;
                continue;
            }
            if(!isAttribute) {
                TextView key = new TextView(context);
                key.setText(columnName);
                key.setGravity(Gravity.LEFT);
                tableRow.addView(key, new TableRow.LayoutParams(ViewGroup.LayoutParams
                  .WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1f));
            }
            TextView value = new TextView(context);
            value.setGravity(Gravity.CENTER);
            if (jsonElement.getAsJsonObject().get(columnName).toString().contains("\"")) {
                value.setText(jsonElement.getAsJsonObject().get(columnName).toString().replace("\"", ""));
            } else {
                value.setText(jsonElement.getAsJsonObject().get(columnName).toString());
            }

            tableRow.addView(value, new TableRow.LayoutParams(ViewGroup.LayoutParams
                    .WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1f));
            TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(ViewGroup
                    .LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            layoutParams.setMargins(12, 16, 12, 16);
            tableLayout.addView(tableRow, layoutParams);
            rowIndex++;
        }

        cardView.addView(tableLayout);

        if(dataTableActionListener != null) {
            tableLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //show DataTableOptions
                    dataTableActionListener.showDataTableOptions(
                      dataTable.getRegisteredTableName(), entityId,
//                            Integer.parseInt(jsonElement.getAsJsonObject().get(dataTable.getColumnHeaderData().get(0).getColumnName()).toString())
                      jsonElement
                    );
                }
            });
        }

        View v = new View(context);
        parentLayout.addView(cardView);
        parentLayout.addView(v, new LayoutParams(LayoutParams
                .MATCH_PARENT, 5));
        return parentLayout;
    }

    public LinearLayout getDataTableLayout(DataTable dataTable, JsonArray jsonElements, LinearLayout linearLayout, FragmentActivity activity, int entityId, DataTableActionListener mListener) {
        return getDataTableLayout(dataTable,
          jsonElements, linearLayout, activity, entityId, false, mListener);
    }

    public LinearLayout getDataTableLayout(DataTable dataTable, JsonElement jsonElement, LinearLayout linearLayout, FragmentActivity activity, int entityId, DataTableActionListener mListener) {
        return createCardView(dataTable, linearLayout, activity, entityId, false, jsonElement);
    }

    public interface DataTableActionListener {
        void showDataTableOptions(String table, int entity, JsonElement jsonElement);
    }
}
