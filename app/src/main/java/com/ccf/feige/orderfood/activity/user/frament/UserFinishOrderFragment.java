package com.ccf.feige.orderfood.activity.user.frament;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import com.ccf.feige.orderfood.R;
import com.ccf.feige.orderfood.activity.user.ManageUserActivity;
import com.ccf.feige.orderfood.activity.user.adapter.OrderFinishUserAdapter;
import com.ccf.feige.orderfood.activity.user.adapter.OrderNoFinishUserAdapter;
import com.ccf.feige.orderfood.bean.OrderBean;
import com.ccf.feige.orderfood.dao.OrderDao;
import com.ccf.feige.orderfood.until.Tools;

import java.util.List;

public class UserFinishOrderFragment extends Fragment {

    View rootview;//根石头

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview=inflater.inflate(R.layout.fragment_manage_user_order_finish, container, false);

        ListView listView= rootview.findViewById(R.id.user_my_order_finish_listView);
        String account= Tools.getOnAccount(rootview.getContext());
        String sta="1";
        List<OrderBean> list = OrderDao.getAllOrdersByStaAndUserFinish(account,sta);
        //List<OrderBean> list = OrderDao.getAllOrders();
        OrderFinishUserAdapter orderNoFinishIstAdapter=new OrderFinishUserAdapter(rootview.getContext(),list);




        if(list==null||list.size()==0){
            listView.setAdapter(null);
        }else{
            listView.setAdapter(orderNoFinishIstAdapter);

        }
        ManageUserActivity man = (ManageUserActivity) getActivity();

                ImageView  imgBack=rootview.findViewById(R.id.user_my_order_finish_back);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                man.showMy();
            }
        });
        SearchView searchView=rootview.findViewById(R.id.user_my_order_finish_search);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                List<OrderBean> list = OrderDao.getAllOrdersByStaAndUserFinish(account,sta);

                List<OrderBean> list1 = Tools.filterOrder(list, query);

                OrderNoFinishUserAdapter orderNoFinishIstAdapter=new OrderNoFinishUserAdapter(rootview.getContext(),list1);
                if(list==null||list.size()==0){
                    listView.setAdapter(null);
                }else{
                    listView.setAdapter(orderNoFinishIstAdapter);

                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                List<OrderBean> list = OrderDao.getAllOrdersByStaAndUserFinish(account,sta);
                List<OrderBean> list1 = Tools.filterOrder(list, newText);
                OrderNoFinishUserAdapter orderNoFinishIstAdapter=new OrderNoFinishUserAdapter(rootview.getContext(),list1);

                if(list==null||list.size()==0){
                    listView.setAdapter(null);
                }else{
                    listView.setAdapter(orderNoFinishIstAdapter);

                }
                return true;
            }
        });


        return rootview;
    }


}