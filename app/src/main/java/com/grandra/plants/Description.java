package com.grandra.plants;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Description extends AppCompatActivity {

    private static final String SERVICE_KEY = "SEyTD6N9tYDcENXw1Yd08q3Snfv%2BdPJOGaXAv74WZInaJlTQ3ZAGiEbcb4PbpVOwH7y5WEuEoTHmP1GmlT6%2B6w%3D%3D";

    private ImageView imageView;
    private String plant_num;
    private String des_imageUrl;
    private Context context;

    private FungiApiClient fungiApiClient;
    private AdView mAdview; //애드뷰 변수 선언

    private TextView bfofMthod;
    private TextView branchDesc;
    private TextView brdMthdDesc;
    private TextView bugInfo;
    private TextView cprtCtnt;
    private TextView dstrb;
    private TextView engNm;
    private TextView familyKorNm;
    private TextView familyNm;
    private TextView farmSpftDesc;
    private TextView flwrDesc;
    private TextView flwrInfo01;
    private TextView flwrInfo02;
    private TextView flwrInfo03;
    private TextView flwrInfo04;
    private TextView flwrInfo05;
    private TextView flwrInfo06;
    private TextView flwrInfo07;
    private TextView flwrInfo08;
    private TextView flwrInfo09;
    private TextView fritDesc;
    private TextView fritInfo01;
    private TextView frstRgstnDtm;
    private TextView gemmaDesc;
    private TextView genusKorNm;
    private TextView genusNm;
    private TextView grwEvrntDesc;
    private TextView inductionDesc;
    private TextView lastUpdtDtm;
    private TextView leafDesc;
    private TextView leafInfo01;
    private TextView leafInfo02;
    private TextView leafInfo03;
    private TextView leafInfo04;
    private TextView leafInfo05;
    private TextView leafInfo06;
    private TextView leafInfo07;
    private TextView leafInfo08;
    private TextView leafInfo09;
    private TextView leafInfo10;
    private TextView note;
    private TextView orplcNm;
    private TextView osDstrb;
    private TextView peltDesc;
    private TextView plantGnrlNm;
    private TextView plantPilbkNo;
    private TextView plantScnmId;
    private TextView plantSpecsScnm;
    private TextView prtcPlnDesc;
    private TextView ramentumDesc;
    private TextView ramentumInfo01;
    private TextView ramentumInfo02;
    private TextView rootDesc;
    private TextView rrngGubun;
    private TextView rrngType;
    private TextView shpe;
    private TextView smlrPlntDesc;
    private TextView spft;
    private TextView sporeDesc;
    private TextView sporeInfo01;
    private TextView sporeInfo02;
    private TextView sporeInfo03;
    private TextView sporeInfo04;
    private TextView sporeInfo05;
    private TextView sporeInfo06;
    private TextView sporeInfo07;
    private TextView sporeInfo08;
    private TextView sporeInfo09;
    private TextView stemDesc;
    private TextView stemInfo01;
    private TextView stemInfo02;
    private TextView stemInfo03;
    private TextView stemInfo04;
    private TextView stemInfo05;
    private TextView stemInfo06;
    private TextView stemInfo07;
    private TextView stemInfo08;
    private TextView sz;
    private TextView useMthdDesc;
    private TextView woodDesc;

    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description);

        this.Init();
        this.image();

        MobileAds.initialize(this, new OnInitializationCompleteListener() { //광고 초기화
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdview = findViewById(R.id.des_adView); //배너광고 레이아웃 가져오기
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER); //광고 사이즈는 배너 사이즈로 설정
        adView.setAdUnitId("\n" + "ca-app-pub-4268507364131475/2013938833");

        // Retrofit 및 API 클라이언트 초기화
        fungiApiClient = new FungiApiClient();

        // API 호출
        Call<FungiResponse> call = fungiApiClient.createService().getFungiInfo(SERVICE_KEY, plant_num);
        call.enqueue(new Callback<FungiResponse>() {
            @Override
            public void onResponse(@NonNull Call<FungiResponse> call, @NonNull Response<FungiResponse> response) {

                if (response.isSuccessful()) {
                    FungiResponse fungiResponse = response.body();
                    if (fungiResponse != null) {
                        FungiItem fungiItem = fungiResponse.getBody().getItem();
                        bfofMthod.setText(fungiItem.getBfofMthod());
                        branchDesc.setText(fungiItem.getBranchDesc());
                        brdMthdDesc.setText(fungiItem.getBrdMthdDesc());
                        bugInfo.setText(fungiItem.getBugInfo());
                        cprtCtnt.setText(fungiItem.getCprtCtnt());
                        dstrb.setText(fungiItem.getDstrb());
                        engNm.setText(fungiItem.getEngNm());
                        familyKorNm.setText(fungiItem.getFamilyKorNm());
                        familyNm.setText(fungiItem.getFamilyNm());
                        farmSpftDesc.setText(fungiItem.getFarmSpftDesc());
                        flwrDesc.setText(fungiItem.getFlwrDesc());
                        flwrInfo01.setText(fungiItem.getFlwrInfo01());
                        flwrInfo02.setText(fungiItem.getFlwrInfo02());
                        flwrInfo03.setText(fungiItem.getFlwrInfo03());
                        flwrInfo04.setText(fungiItem.getFlwrInfo04());
                        flwrInfo05.setText(fungiItem.getFlwrInfo05());
                        flwrInfo06.setText(fungiItem.getFlwrInfo06());
                        flwrInfo07.setText(fungiItem.getFlwrInfo07());
                        flwrInfo08.setText(fungiItem.getFlwrInfo08());
                        flwrInfo09.setText(fungiItem.getFlwrInfo09());
                        fritDesc.setText(fungiItem.getFritDesc());
                        fritInfo01.setText(fungiItem.getFritInfo01());
                        frstRgstnDtm.setText(fungiItem.getFrstRgstnDtm());
                        gemmaDesc.setText(fungiItem.getGemmaDesc());
                        genusKorNm.setText(fungiItem.getGenusKorNm());
                        genusNm.setText(fungiItem.getGenusNm());
                        grwEvrntDesc.setText(fungiItem.getGrwEvrntDesc());
                        inductionDesc.setText(fungiItem.getInductionDesc());
                        lastUpdtDtm.setText(fungiItem.getLastUpdtDtm());
                        leafDesc.setText(fungiItem.getLeafDesc());
                        leafInfo01.setText(fungiItem.getLeafInfo01());
                        leafInfo02.setText(fungiItem.getLeafInfo02());
                        leafInfo03.setText(fungiItem.getLeafInfo03());
                        leafInfo04.setText(fungiItem.getLeafInfo04());
                        leafInfo05.setText(fungiItem.getLeafInfo05());
                        leafInfo06.setText(fungiItem.getLeafInfo06());
                        leafInfo07.setText(fungiItem.getLeafInfo07());
                        leafInfo08.setText(fungiItem.getLeafInfo08());
                        leafInfo09.setText(fungiItem.getLeafInfo09());
                        leafInfo10.setText(fungiItem.getLeafInfo10());
                        note.setText(fungiItem.getNote());
                        orplcNm.setText(fungiItem.getOrplcNm());
                        osDstrb.setText(fungiItem.getOsDstrb());
                        peltDesc.setText(fungiItem.getPeltDesc());
                        plantGnrlNm.setText(fungiItem.getPlantGnrlNm());
                        plantPilbkNo.setText(fungiItem.getPlantPilbkNo());
                        plantScnmId.setText(fungiItem.getPlantScnmId());
                        plantSpecsScnm.setText(fungiItem.getPlantSpecsScnm());
                        prtcPlnDesc.setText(fungiItem.getPrtcPlnDesc());
                        ramentumDesc.setText(fungiItem.getRamentumDesc());
                        ramentumInfo01.setText(fungiItem.getRamentumInfo01());
                        ramentumInfo02.setText(fungiItem.getRamentumInfo02());
                        rootDesc.setText(fungiItem.getRootDesc());
                        rrngGubun.setText(fungiItem.getRrngGubun());
                        rrngType.setText(fungiItem.getRrngType());
                        shpe.setText(fungiItem.getShpe());
                        smlrPlntDesc.setText(fungiItem.getSmlrPlntDesc());
                        spft.setText(fungiItem.getSpft());
                        sporeDesc.setText(fungiItem.getSporeDesc());
                        sporeInfo01.setText(fungiItem.getSporeInfo01());
                        sporeInfo02.setText(fungiItem.getSporeInfo02());
                        sporeInfo03.setText(fungiItem.getSporeInfo03());
                        sporeInfo04.setText(fungiItem.getSporeInfo04());
                        sporeInfo05.setText(fungiItem.getSporeInfo05());
                        sporeInfo06.setText(fungiItem.getSporeInfo06());
                        sporeInfo07.setText(fungiItem.getSporeInfo07());
                        sporeInfo08.setText(fungiItem.getSporeInfo08());
                        sporeInfo09.setText(fungiItem.getSporeInfo09());
                        stemDesc.setText(fungiItem.getStemDesc());
                        stemInfo01.setText(fungiItem.getStemInfo01());
                        stemInfo02.setText(fungiItem.getStemInfo02());
                        stemInfo03.setText(fungiItem.getStemInfo03());
                        stemInfo04.setText(fungiItem.getStemInfo04());
                        stemInfo05.setText(fungiItem.getStemInfo05());
                        stemInfo06.setText(fungiItem.getStemInfo06());
                        stemInfo07.setText(fungiItem.getStemInfo07());
                        stemInfo08.setText(fungiItem.getStemInfo08());
                        sz.setText(fungiItem.getSz());
                        useMthdDesc.setText(fungiItem.getUseMthdDesc());
                        woodDesc.setText(fungiItem.getWoodDesc());
                        title.setText(fungiItem.getPlantGnrlNm());

                    }
                } else {
                    // API 호출 실패 처리
                    ResponseBody errorBody = response.errorBody();
                    if (errorBody != null) {
                        try {
                            String errorResponse = errorBody.string();
                            Log.e("API Error", "Error Response: " + errorResponse);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        Log.e("API Error", "Unknown error occurred.");
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<FungiResponse> call, @NonNull Throwable t) {
                // 네트워크 오류 처리
                Log.e("MainActivity", "Network error: " + t.getMessage());
            }
        });
    }

    private void Init() {
        title = findViewById(R.id.plant_title);
        imageView = findViewById(R.id.des_imageView);
        plant_num = getIntent().getStringExtra("plant_num");
        des_imageUrl = getIntent().getStringExtra("plant_image");
        bfofMthod = findViewById(R.id.bfofMthod);
        branchDesc = findViewById(R.id.branchDesc);
        brdMthdDesc = findViewById(R.id.brdMthdDesc);
        bugInfo = findViewById(R.id.bugInfo);
        cprtCtnt = findViewById(R.id.cprtCtnt);
        dstrb = findViewById(R.id.dstrb);
        engNm = findViewById(R.id.engNm);
        familyKorNm = findViewById(R.id.familyKorNm);
        familyNm = findViewById(R.id.familyNm);
        farmSpftDesc = findViewById(R.id.farmSpftDesc);
        flwrDesc = findViewById(R.id.flwrDesc);
        flwrInfo01 = findViewById(R.id.flwrInfo01);
        flwrInfo02 = findViewById(R.id.flwrInfo02);
        flwrInfo03 = findViewById(R.id.flwrInfo03);
        flwrInfo04 = findViewById(R.id.flwrInfo04);
        flwrInfo05 = findViewById(R.id.flwrInfo05);
        flwrInfo06 = findViewById(R.id.flwrInfo06);
        flwrInfo07 = findViewById(R.id.flwrInfo07);
        flwrInfo08 = findViewById(R.id.flwrInfo08);
        flwrInfo09 = findViewById(R.id.flwrInfo09);
        fritDesc = findViewById(R.id.fritDesc);
        fritInfo01 = findViewById(R.id.fritInfo01);
        frstRgstnDtm = findViewById(R.id.frstRgstnDtm);
        gemmaDesc = findViewById(R.id.gemmaDesc);
        genusKorNm = findViewById(R.id.genusKorNm);
        genusNm = findViewById(R.id.genusNm);
        grwEvrntDesc = findViewById(R.id.grwEvrntDesc);
        inductionDesc = findViewById(R.id.inductionDesc);
        lastUpdtDtm = findViewById(R.id.lastUpdtDtm);
        leafDesc = findViewById(R.id.leafDesc);
        leafInfo01 = findViewById(R.id.leafInfo01);
        leafInfo02 = findViewById(R.id.leafInfo02);
        leafInfo03 = findViewById(R.id.leafInfo03);
        leafInfo04 = findViewById(R.id.leafInfo04);
        leafInfo05 = findViewById(R.id.leafInfo05);
        leafInfo06 = findViewById(R.id.leafInfo06);
        leafInfo07 = findViewById(R.id.leafInfo07);
        leafInfo08 = findViewById(R.id.leafInfo08);
        leafInfo09 = findViewById(R.id.leafInfo09);
        leafInfo10 = findViewById(R.id.leafInfo10);
        note = findViewById(R.id.note);
        orplcNm = findViewById(R.id.orplcNm);
        osDstrb = findViewById(R.id.osDstrb);
        peltDesc = findViewById(R.id.peltDesc);
        plantGnrlNm = findViewById(R.id.plantGnrlNm);
        plantPilbkNo = findViewById(R.id.plantPilbkNo);
        plantScnmId = findViewById(R.id.plantScnmId);
        plantSpecsScnm = findViewById(R.id.plantSpecsScnm);
        prtcPlnDesc = findViewById(R.id.prtcPlnDesc);
        ramentumDesc = findViewById(R.id.ramentumDesc);
        ramentumInfo01 = findViewById(R.id.ramentumInfo01);
        ramentumInfo02 = findViewById(R.id.ramentumInfo02);
        rootDesc = findViewById(R.id.rootDesc);
        rrngGubun = findViewById(R.id.rrngGubun);
        rrngType = findViewById(R.id.rrngType);
        shpe = findViewById(R.id.shpe);
        smlrPlntDesc = findViewById(R.id.smlrPlntDesc);
        spft = findViewById(R.id.spft);
        sporeDesc = findViewById(R.id.sporeDesc);
        sporeInfo01 = findViewById(R.id.sporeInfo01);
        sporeInfo02 = findViewById(R.id.sporeInfo02);
        sporeInfo03 = findViewById(R.id.sporeInfo03);
        sporeInfo04 = findViewById(R.id.sporeInfo04);
        sporeInfo05 = findViewById(R.id.sporeInfo05);
        sporeInfo06 = findViewById(R.id.sporeInfo06);
        sporeInfo07 = findViewById(R.id.sporeInfo07);
        sporeInfo08 = findViewById(R.id.sporeInfo08);
        sporeInfo09 = findViewById(R.id.sporeInfo09);
        stemDesc = findViewById(R.id.stemDesc);
        stemInfo01 = findViewById(R.id.stemInfo01);
        stemInfo02 = findViewById(R.id.stemInfo02);
        stemInfo03 = findViewById(R.id.stemInfo03);
        stemInfo04 = findViewById(R.id.stemInfo04);
        stemInfo05 = findViewById(R.id.stemInfo05);
        stemInfo06 = findViewById(R.id.stemInfo06);
        stemInfo07 = findViewById(R.id.stemInfo07);
        stemInfo08 = findViewById(R.id.stemInfo08);
        sz = findViewById(R.id.sz);
        useMthdDesc = findViewById(R.id.useMthdDesc);
        woodDesc = findViewById(R.id.woodDesc);
    }

    private void image(){
        RequestOptions requestOptions = new RequestOptions()
                .transform(new RoundedCorners(20)) // 둥글게 처리를 위한 RoundedCorners 변환 적용
                .diskCacheStrategy(DiskCacheStrategy.ALL); // 디스크 캐싱 전략 설정

        Glide.with(this)
                .load(des_imageUrl)
                .apply(requestOptions)
                .transition(DrawableTransitionOptions.withCrossFade()) // 이미지 로딩 시 CrossFade 효과 적용
                .diskCacheStrategy(DiskCacheStrategy.ALL) // 디스크 캐싱 전략 설정
                .into(imageView);
    }
}