package com.example.newsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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

public class BusFragment extends Fragment {
    RecyclerView mrecylerview;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_list, container, false);
        getgeneral();
        mrecylerview=view.findViewById(R.id.rcyclr3);
        mrecylerview.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager =
                new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        mrecylerview.setLayoutManager(mLayoutManager);
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    private void getgeneral() {




        GetDataService service = RetrofirClientInstance.getRetrofit().create(GetDataService.class);
        Call<GenResponse> call = service.getbus();
        call.enqueue(new Callback<GenResponse>() {
            @Override
            public void onResponse(Call<GenResponse> call, Response<GenResponse> response) {


                List<GenResponse.Source> dlist= response.body().getSources();
                mrecylerview.setAdapter(new GenAdapter(getActivity(),dlist));

            }
            @Override
            public void onFailure(Call<GenResponse> call, Throwable t) {

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
