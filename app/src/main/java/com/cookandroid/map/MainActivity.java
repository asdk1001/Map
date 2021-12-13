package com.cookandroid.map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity extends AppCompatActivity
    implements OnMapReadyCallback {

        private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.Map);
        mapFragment.getMapAsync(this);
    }

    //학교 마커
    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;

        LatLng SCHOOL = new LatLng(37.58473689920632, 126.92479616829252);
        //학교 위도 경도 지정
        LatLng SUBWAY = new LatLng(37.59114867736814, 126.91362054506624);
        //지하철역 위도 경도 지정

        //마커 옵션 설정
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(SCHOOL);
        markerOptions.title("명지전문대");
        markerOptions.snippet("학교 위치");
        mMap.addMarker(markerOptions);
        //학교마커 옵션
        markerOptions.position(SUBWAY);
        markerOptions.title("새절역");
        markerOptions.snippet("가장 가까운 지하철역 위치입니다.");
        mMap.addMarker(markerOptions);
        //지하철역마커 옵션

        //경로긋기
        LatLng loc1 = new LatLng(37.59114867736814, 126.91362054506624);
        //시작포인트
        LatLng loc2 = new LatLng(37.592591096310116, 126.91402399152877);
        //중간 꺾이는 포인트
        mMap.addPolyline(new PolylineOptions().add(loc1, loc2).width(5).color(Color.BLUE));

        LatLng loc3 = new LatLng(37.592591096310116, 126.91402399152877);
        //시작포인트
        LatLng loc4 = new LatLng(37.58473689920632, 126.92479616829252);
        //끝포인트
        mMap.addPolyline(new PolylineOptions().add(loc3, loc4).width(5).color(Color.BLUE));

        LatLng MIDDLE = new LatLng(37.58726036430125, 126.91922838114945);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MIDDLE, 15));
    }


}