package masterung.th.in.androidthai.mytutorial;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CatetoryFragment extends Fragment implements View.OnClickListener {

    private ImageView imageView1, imageView2, imageView3;


    public CatetoryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        imageView1 = getView().findViewById(R.id.imvCat1);
        imageView2 = getView().findViewById(R.id.imvCat2);
        imageView3 = getView().findViewById(R.id.imvCat3);

        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);

//        Phone Controller
        phoneController();

    }   // Main Method

    private void phoneController() {
        ImageView imageView = getView().findViewById(R.id.imvPhone);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_CALL);
                String phone = "0819229099";
                intent.setData(Uri.parse("tel:" + phone));
                startActivity(intent);

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_catetory, container, false);
    }

    @Override
    public void onClick(View v) {

        int index = 0;
        switch (v.getId()) {
            case R.id.imvCat1:
                index = 0;
                moveToShowList(index);
                break;
            case R.id.imvCat2:
                index = 1;
                moveToShowList(index);
                break;
            case R.id.imvCat3:
                index = 2;
                moveToShowList(index);
                break;
        }

    }

    private void moveToShowList(int index) {
        getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contentServiceFragment, ListVideoFragment.listVideoInstance(index))
                .addToBackStack(null)
                .commit();
    }
}
