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


