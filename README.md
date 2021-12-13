# Map
Google_map

2021년 2학기 앱개발기초 기말프로젝트 보고서
2021661030 김현빈

1. 프로젝트 설명
이번 기말프로젝트로 제가 제작한 안드로이드 앱은 가장 가까운 지하철역과 학교까지의 경로를 표시하는 앱입니다.
이 앱을 만들게 된 이유는 집과 학교가 멀리 떨어져 있어서 지하철과 버스를 타고 등교를 하는데, 익숙한 지역이 아니라서
길을 잘 모릅니다. 이러한 와중에 저번주에 버스를 잘못타 이상한 곳에서 내려 길을 헤맨 경험이 있습니다. 구글맵을 보고
길을 찾으면서 30분정도 걸어 지하철역을 찾았는데, 구글맵에 학교와 지하철역사이의 경로가 표시되면 길 찾기 편할 것 
같다는 생각이 들어서 이 앱을 제가 쓸려고 개발하게 되었습니다.

2. 사용 기술 설명
우선 구글맵API를 사용했습니다. Google CloudPlatform에서 API를 받고, 명령크롬프트를 통해 SHA-1인증서를 받은 뒤 입력해 
구글맵API를 받아 사용했습니다.
구글맵API를 사용하기 위해 xml에서 fragmet을 사용하였습니다.
MainActivity에서는 OnMapReadyCallback와 SupportMapFragment을 사용했습니다.
이를 사용해 미리 설치한 Google Play서비스를 사용해 지도를 불러와 구현했습니다.
LatLng SCHOOL = new LatLng(37.58473689920632, 126.92479616829252);를 통해 마커의 좌표를 지정한 후
MarkerOptions markerOptions = new MarkerOptions();
markerOptions.position(SCHOOL);
markerOptions.title("명지전문대");
markerOptions.snippet("학교 위치");
mMap.addMarker(markerOptions);
를 사용해 마커를 클릭했을 때 뜰 문구와 같은 마커옵션을 설정했습니다.

그리고 맵에 경로를 그리기 위해 addPolyline를 사용했습니다.
addPolyline에 필요한 시작지점의 좌표와 끝나는 지점의 좌표를 LatLng loc1 = new LatLng(37.59114867736814, 126.91362054506624);
와 같이 지정한 후 mMap.addPolyline(new PolylineOptions().add(loc1, loc2).width(5).color(Color.BLUE));와 같은 형식으로
시작지점과 끝지점, 선의 굵기, 색상등을 설정하고 배치했습니다.
마지막으로 앱을 처음 켰을때의 두 마커의 중앙이 나오도록 mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SCHOOL, 15));를 사용해 시작지점과 확대비율을 지정했습니다.
