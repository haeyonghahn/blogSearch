# 목차
* **[API 명세서](#api-명세서)**
  * **[블로그 검색](#블로그-검색)**
  * **[인기 검색어 목록](#인기-검색어-목록)**
* **[외부 라이브러리 및 오픈소스 사용](#외부-라이브러리-및-오픈소스-사용)**
* **[Executable jar 다운로드](#executable-jar-다운로드)**
# API 명세서
## 블로그 검색
```
GET /blog/search
Host: http://localhost:8080
```
키워드를 통해 블로그를 검색합니다.

## Request
__Parameter__
|Name|Type|Description|Required|
|----|------------------------|-------------------------|---|
|query|String|검색을 원하는 질의어|O|
|sort|String|결과 문서 정렬 방식, accuracy(정확도순) 또는 recency(최신순), 기본 값 accuracy|X|
|page|Integer|결과 페이지 번호, 1~50 사이의 값, 기본 값 1|X|
|size|Integer|한 페이지에 보여질 문서 수, 1~50 사이의 값, 기본 값 10|X|

## Response
### blogResponseDto
|Name|Type|Description|
|----|------------------------|-----|
|totalPosts|Integer|노출 가능 문서 수|
|postPerPage|Integer|페이지 당 문서 수|

__blogDocumentDtos__   
|Name|Type|Description|
|----|------------------------|-----|
|title|String|블로그 글 제목|
|contents|String|블로그 글 요약|
|url|String|블로그 글 URL|
|blogname|String|블로그의 이름|
|thumbnail|String|검색 시스템에서 추출한 대표 미리보기 이미지 URL|
|datetime|String|블로그 글 작성시간|

## Sample
__Request__   
```
curl -v -X GET "http://localhost:8080/blog/search" \
--data-urlencode "query=https://brunch.co.kr/@tourism" \
```
__Response__   
```json
{
  "totalPosts": 2,
  "postPerPage": 10,
  "blogDocumentDtos": [
    {
        "title": "[여행?희망!] _ 브런치 연재글 다음 메인에 선정",
        "contents": "브런치 메인에도 선정이 되었습니다. 정란수의 브런치 연재글은 다음의 링크에서 보실 수 있습니다~ 브런치 내 제 글을 보시려면 다음의 링크를 따라가주세요 ^^ <b>https://brunch.co.kr/@tourism</b> 정란수의 브런치 여행다니면서 일하는 &#34;한량&#34;! &lt;개념여행&gt; 저자이면서, 관광개발 컨설팅을 하고 돌아다님 www.tourism.re.kr...",
        "url": "https://blog.naver.com/jeongransoo/220600431408",
        "blogname": "<개념여행>, <여행을가다, 희망을보다> 저자 정란수",
        "thumbnail": "https://search3.kakaocdn.net/argon/130x130_85_c/7dtORyQIlj3",
        "datetime": "2016-01-17T23:24:00.000+09:00"
    },
    {
        "title": "여행을 통해 희망을 발견하기 브런치 연재 시작",
        "contents": "희망을 발견하자는 내용으로, 이른바 &#34;헬조선&#34;을 극복하기 위해 여행에서 만난 다양한 이야기를 풀어나가려 합니다. 링크는 다음과 같습니다 ^^ <b>https://brunch.co.kr/@tourism</b> 정란수의 브런치 여행다니면서 일하는 &#34;한량&#34;! &lt;개념여행&gt;이라는 책을 펴냈다가 출판사에 미안하게 되어버림. brunch.co.kr 아마도 이 블로그...",
        "url": "https://blog.naver.com/jeongransoo/220511478588",
        "blogname": "<개념여행>, <여행을가다, 희망을보다> 저자 정란수",
        "thumbnail": "https://search4.kakaocdn.net/argon/130x130_85_c/EvscfrxMzLn",
        "datetime": "2015-10-17T16:44:00.000+09:00"
    }
  ]
}
```

## 인기 검색어 목록
```
GET /blog/keyword
Host: http://localhost:8080
```
사용자들이 많이 검색한 순서대로, 최대 10개의 검색 키워드를 제공합니다.

## Response
### KeywordDto
|Name|Type|Description|
|----|------------------------|-----|
|keyword|String|검색어|
|count|Long|검색어 별로 검색된 횟수|
|date|Datetime|검색어 별로 검색된 최근 일자|

## Sample
__Request__   
```
curl -v -X GET "http://localhost:8080/blog/keyword"
```
__Response__   
```json
[
    {
        "keyword": "여행",
        "count": 2,
        "date": "2023-03-22T12:28:16.610+00:00"
    },
    {
        "keyword": "곽튜브",
        "count": 2,
        "date": "2023-03-22T12:27:30.246+00:00"
    },
    {
        "keyword": "아메리카노",
        "count": 1,
        "date": "2023-03-22T12:28:36.698+00:00"
    },
    {
        "keyword": "여행일기",
        "count": 1,
        "date": "2023-03-22T12:28:20.314+00:00"
    },
    {
        "keyword": "남산",
        "count": 1,
        "date": "2023-03-22T12:27:56.420+00:00"
    },
    {
        "keyword": "빵 카페",
        "count": 1,
        "date": "2023-03-22T12:27:48.945+00:00"
    },
    {
        "keyword": "노홍철",
        "count": 1,
        "date": "2023-03-22T12:27:43.904+00:00"
    },
    {
        "keyword": "원지의 하루",
        "count": 1,
        "date": "2023-03-22T12:27:39.176+00:00"
    },
    {
        "keyword": "빠니보틀",
        "count": 1,
        "date": "2023-03-22T12:27:34.834+00:00"
    },
    {
        "keyword": "https://brunch.co.kr/@tourism",
        "count": 1,
        "date": "2023-03-22T12:20:47.850+00:00"
    }
]
```

# 외부 라이브러리 및 오픈소스 사용
- jpa   
ORM 기술을 위한 라이브러리 용도
- web   
웹 애플리케이션을 작성하기 위한 용도
- validation     
데이터의 값이 유효한지 검사하기 위한 용도
- openfeign   
Rest Call 을 위해 호출하는 클라이언트를 쉽게 작성하기 위한 용도
- querydsl   
JPQL을 Java 코드로 작성하기 위한 용도
- p6spy    
쿼리 파라미터를 로그에 남겨주는 용도 
- circuitbreaker-resilience4j   
Rest Call 의 장애 감지를 위한 용도
- lombok   
Java의 반복되는 메소드를 어노테이션을 사용해서 자동으로 작성해주기 위한 용도
- devtools   
스프링 부트 개발 편의를 위한 용도
- h2   
In-Memory DB 사용
- test   
스프링 부트 테스트를 위한 용도
- jacoco   
테스트 커버리지 측정을 위한 용도

# Executable jar 다운로드
[다운로드 링크](https://raw.githubusercontent.com/haeyonghahn/blogSearch/blob/master/executable/blogSearch-1.0-SNAPSHOT.jar)
