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
```
<br/><br/>

# 3. 카메라의 위치와 줌(Zoom)설정 
지도에 관한 설정은 모두 onMapReady에 작성하면 된다.
## 위도와 경도 값을 지정
>`LatLng` : 지도상의 위도, 경도 값을 저장하는 클래스 <br/>
>LatLng ( double latitude, double longitude )
```
// 위치(위도,경도) 객체
LatLng location = new LatLng(37.487936, 126.825071);
```
<br/>

## 카메라 위치와 줌 조절
>`CameraPosition` : 카메라의 위치와 줌 정의 값을 저장하는 클래스<br/>
>`setCameraPosition()` : 해당하는 네이버 지도 객체에 카메라 위치를 설정하는 메소드. CameraPosition 객체가 인자값으로 들어간다.<br/>
>`naverMap`은 `onMapReady()`메소드에서 인자값으로 받아온 객체
```
// 카메라 위치와 줌 조절(숫자가 클수록 확대)
CameraPosition cameraPosition = new CameraPosition(location, 17);
naverMap.setCameraPosition(cameraPosition);
```
<br/>

## 쥼 범위 제한
>`setMinZoom()` : 최소 줌 범위 제한 (가장 멀리 보이는 정도)<br/>
>`setMaxZoom()` : 최대 줌 범위 제한 (가장 멀리 가까이 정도)
```
// 줌 범위 제한
naverMap.setMinZoom(5.0);   //최소
naverMap.setMaxZoom(18.0);  //최대
```
<br/>

## 카메라 영역 범위 제한
>`setExtent()` : 카메라가 이동할 수 있는 최대 서북단, 동남단을 지정
```
// 카메라 영역 제한
LatLng northWest = new LatLng(31.43, 122.37);   //서북단
LatLng southEast = new LatLng(44.35, 132);      //동남단
naverMap.setExtent(new LatLngBounds(northWest, southEast));
```
