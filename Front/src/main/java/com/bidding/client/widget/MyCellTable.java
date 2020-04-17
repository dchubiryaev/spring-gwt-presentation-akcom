package com.bidding.client.widget;


import com.google.gwt.user.cellview.client.SimplePager;
import org.gwtbootstrap3.client.ui.gwt.CellTable;

public class MyCellTable extends CellTable {
    public MyCellTable(){
        //seEmptyTableWidget(new Label(" No Records Found"));
    }

    public SimplePager LimitTable(int height){
        SimplePager pager = new SimplePager();
        pager.setDisplay(this);
        pager.setPage(10);
        pager.setPageSize(height);
        return pager;
    }
}
