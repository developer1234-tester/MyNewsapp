package com.example.newsapp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.newsapp.model.HeadlineResponse;

import java.io.IOException;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryFragment extends Fragment {
    RecyclerView mrecylerview;
    ProgressDialog progressDoalog;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_list, container, false);

        mrecylerview=view.findViewById(R.id.rcyclr3);
        RecyclerView.LayoutManager mLayoutManager =
                new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        mrecylerview.setLayoutManager(mLayoutManager);
        getNews();
        return super.onCreateView(inflater, container, savedInstanceState);

    }
    private void getNews() {
//        mrecylerview.setHasFixedSize(true);
//        RecyclerView.LayoutManager mLayoutManager =
//                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
//
//        mrecylerview.setLayoutManager(mLayoutManager);


        progressDoalog = new ProgressDialog(getActivity());
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();
        GetDataService service = RetrofirClientInstance.getRetrofit().create(GetDataService.class);
        Call<CategoryResponse> call = service.getCatry();
        call.enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {


                progressDoalog.dismiss();
                List<CategoryResponse.Source> dlist= response.body().getSources();
                mrecylerview.setAdapter(new NewsAdapter(getContext(),dlist));
            }
            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {

                progressDoalog.dismiss();
                //  Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                if (t instanceof IOException) {
                    Toast.makeText(getContext(), "this is an actual network failure :( inform the user and possibly retry", Toast.LENGTH_SHORT).show();
                    // logging probably not necessary
                }
                else {
                    Toast.makeText(getContext(), "conversion issue! big problems :(", Toast.LENGTH_SHORT).show();
                    // todo log to some central bug tracking service
                }
            }
        });
    }

}
