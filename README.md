# Android-Naver-Map-API-Sample
안드로이드 네이버 지도 API 예제<br /><br /><br />

# 1. 네이버 지도 시작하기 

## API 호출
>build.gradle
```
repositories {
    ...

    // 네이버 지도 저장소
    maven {
        url 'https://navercorp.bintray.com/maps'
    }
}
```       

>build.gradle(app)
```
dependencies {
    ...

    // 네이버 지도 SDK
    implementation 'com.naver.maps:map-sdk:3.0.0'
}
```

>AndroidManifest.xml
```
<manifest>
    <application>
        <meta-data
            android:name="com.naver.maps.map.CLIENT_ID"
            android:value="YOUR_CLIENT_ID_HERE" />
    </application>
</manifest>
```
<br />

## 지도 표시
>표시하고 싶은 xml 레이아웃에 추가

```
<fragment 
    android:id="@+id/map"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:name="com.naver.maps.map.MapFragment" />
```





<br /><br /><br />

# 2. 네이버 지도의 속성을 지정하기 위한 첫 단계

## 지도 객체 받아오기
> 클래스에 인터페이스 `OnMapReadyCallback` 을 구현 해야한다.<br/>
> OnCreate()안에서 지도 객체를 받아와야 한다.

```
// 지도 객체 받아오기
MapFragment mapFragment = (MapFragment) getSupportFragmentManager().findFragmentById(R.id.zoompos_map);
if (mapFragment == null) {
    mapFragment = MapFragment.newInstance();
    getSupportFragmentManager().beginTransaction().add(R.id.zoompos_map, mapFragment).commit();
}

mapFragment.getMapAsync(this);
```

>`onMapReady()` : 맵을 생성할 준비가 되었을 때 가장 먼저 호출되는 오버라이드 메소드이다. <br/>
>이 메소드 안에서 지도의 속성을 초기화할 수 있다. 
```
@UiThread
@Override
public void onMapReady(@NonNull NaverMap naverMap) {
    //... (실행될 코드) ...
}