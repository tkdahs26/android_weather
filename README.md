# android_weather
![asdasd](https://user-images.githubusercontent.com/48806275/129286601-014e4e16-19ab-4401-a36e-f238a3afc617.png)
첫번째 어플만들기 날씨앱  
기상청api를 활용해 날씨,미세먼지를 보는 앱입니다
Java와 안드로이드 환경에서 공공 데이터 포털의 미세먼지, 기상 특보, 주간 예보 등의 API를 연동하여 실시간 정보를 사용자에게 제공하는 모바일 애플리케이션을 개발했습니다. API 연동, JSON 데이터 처리 및 동적 UI 구성 능력을 집중적으로 키웠습니다.


1. 공공 API 연동 및 데이터 수집
 

미세먼지/초미세먼지, 기상 특보, 주간 날씨 예보 등 총 3종 이상의 공공 API를 분석하고 연동하여 데이터를 수집했습니다. 



2. JSON 데이터 처리 및 파싱 로직 구현

기상 특보 정보에서발표 시각과 발표 내용 등 원하는 정보를 추출하고 처리했습니다.

3. 정보 시각화 및 동적 UI 구성

날씨 정보에 따라 TextView 옆에 아이콘 이미지를 동적으로 변경했습니다.

미세먼지 수치에 따라 TextView의 글자색을 변경 구현하여 사용자에게 정보를 전달했습니다.  

 















사용기술 android java json  공공 데이터 포털 API

<img src="https://user-images.githubusercontent.com/48806275/129467785-a2b1107f-dae6-40ed-bc15-25728f56e914.png " width="20%" height="200%"/>첫화면: 날씨 기상특보 미세먼지 초미세먼지

<img src="https://user-images.githubusercontent.com/48806275/129467786-86a9deda-37f5-4fc5-b3fd-5383469b7413.png " width="20%" height="200%"/>날씨클릭: 지역별로 현재날씨 출력<img src="https://user-images.githubusercontent.com/48806275/129467780-408e8a8c-5368-4725-9ec2-5624f4e4a5cf.png " width="20%" height="200%"/>날씨의 아이콘클릭: 클릭한 지역의 3일까지 기상예보 데이터출력

<img src="https://user-images.githubusercontent.com/48806275/129467781-315f9462-4bb9-46e5-a24a-c24a8d102d0f.png " width="20%" height="200%"/>기상특보버튼클릭: 지역별 특보개수출력<img src="https://user-images.githubusercontent.com/48806275/129467782-0c3d7b72-c84d-47f0-b13d-e0bf7594a680.png " width="20%" height="200%"/>지도클릭: 해당 지역이 포함된 특보출력

<img src="https://user-images.githubusercontent.com/48806275/129467913-06f6297c-a803-4502-94af-6d0bec0a8c1d.png " width="20%" height="200%"/>미세먼지버튼클릭: 지역별 하늘색 0-30 초록색30-80 주황 80-150 빨강 151-

<img src="https://user-images.githubusercontent.com/48806275/129467915-bf635a97-f772-4317-8032-8baffb660773.png " width="20%" height="200%"/>초미세먼지버튼클릭: 초미세먼지 정보출력

