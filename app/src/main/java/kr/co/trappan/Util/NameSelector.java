package kr.co.trappan.Util;

/**
 * Created by jongchanrim on 2016. 11. 14..
 */

public class NameSelector {

    private static NameSelector client = new NameSelector();

    public static String selectAreaName(String areacode){
        String areaName = "";
        int code = Integer.parseInt(areacode);
        switch (code){
            case 1: areaName = "서울특별시"; break;
            case 2: areaName = "인천광역시"; break;
            case 3: areaName = "대전광역시"; break;
            case 4: areaName = "대구광역시"; break;
            case 5: areaName = "광주광역시"; break;
            case 6: areaName = "부산광역시"; break;
            case 7: areaName = "울산광역시"; break;
            case 8: areaName = "세종시"; break;
            case 31: areaName = "경기도"; break;
            case 32: areaName = "강원도"; break;
            case 33: areaName = "충청북도"; break;
            case 34: areaName = "충청남도"; break;
            case 35: areaName = "경상북도"; break;
            case 36: areaName = "경상남도"; break;
            case 37: areaName = "전라북도"; break;
            case 38: areaName = "전라남도"; break;
            case 39: areaName = "제주도"; break;
            default: break;
        }

        return areaName;
    }


    public static String selectSigunguName(String areacode, String sigungucode){
        String sigunguName = "";
        int acode = Integer.parseInt(areacode);
        int scode = Integer.parseInt(sigungucode);

        switch (acode){
            case 1: switch(scode){
                    case 1: sigunguName = "강남구"; break;
                    case 2: sigunguName = "강동구"; break;
                    case 3: sigunguName = "강북구"; break;
                    case 4: sigunguName = "강서구"; break;
                    case 5: sigunguName = "관악구"; break;
                    case 6: sigunguName = "광진구"; break;
                    case 7: sigunguName = "구로구"; break;
                    case 8: sigunguName = "금천구"; break;
                    case 9: sigunguName = "노원구"; break;
                    case 10: sigunguName = "도봉구"; break;
                    case 11: sigunguName = "동대문구"; break;
                    case 12: sigunguName = "동작구"; break;
                    case 13: sigunguName = "마포구"; break;
                    case 14: sigunguName = "서대문구"; break;
                    case 15: sigunguName = "서초구"; break;
                    case 16: sigunguName = "성동구"; break;
                    case 17: sigunguName = "성북구"; break;
                    case 18: sigunguName = "송파구"; break;
                    case 19: sigunguName = "양천구"; break;
                    case 20: sigunguName = "영등포구"; break;
                    case 21: sigunguName = "용산구"; break;
                    case 22: sigunguName = "은평구"; break;
                    case 23: sigunguName = "종로구"; break;
                    case 24: sigunguName = "중구"; break;
                    case 25: sigunguName = "중랑구"; break;
                    }break;
            case 2: switch(scode){
                case 1: sigunguName = "강화군"; break;
                case 2: sigunguName = "계양구"; break;
                case 3: sigunguName = "남구"; break;
                case 4: sigunguName = "남동구"; break;
                case 5: sigunguName = "동구"; break;
                case 6: sigunguName = "부평구"; break;
                case 7: sigunguName = "서구"; break;
                case 8: sigunguName = "연수구"; break;
                case 9: sigunguName = "옹진군"; break;
                case 10: sigunguName = "중구"; break;

            }break;
            case 3: switch(scode){
                case 1: sigunguName = "대덕구"; break;
                case 2: sigunguName = "동구"; break;
                case 3: sigunguName = "서구"; break;
                case 4: sigunguName = "유성구"; break;
                case 5: sigunguName = "중구"; break;

            }break;
            case 4: switch(scode){
                case 1: sigunguName = "남구"; break;
                case 2: sigunguName = "달서구"; break;
                case 3: sigunguName = "달성군"; break;
                case 4: sigunguName = "동구"; break;
                case 5: sigunguName = "북구"; break;
                case 6: sigunguName = "서구"; break;
                case 7: sigunguName = "수성구"; break;
                case 8: sigunguName = "중구"; break;

            }break;
            case 5: switch(scode){
                case 1: sigunguName = "광산구"; break;
                case 2: sigunguName = "남구"; break;
                case 3: sigunguName = "동구"; break;
                case 4: sigunguName = "북구"; break;
                case 5: sigunguName = "서구"; break;

            }break;
            case 6: switch(scode){
                case 1: sigunguName = "강서구"; break;
                case 2: sigunguName = "금정구"; break;
                case 3: sigunguName = "기장군"; break;
                case 4: sigunguName = "남구"; break;
                case 5: sigunguName = "동구"; break;
                case 6: sigunguName = "동래구"; break;
                case 7: sigunguName = "부산진구"; break;
                case 8: sigunguName = "북구"; break;
                case 9: sigunguName = "사상구"; break;
                case 10: sigunguName = "사하구"; break;
                case 11: sigunguName = "서구"; break;
                case 12: sigunguName = "수영구"; break;
                case 13: sigunguName = "연제구"; break;
                case 14: sigunguName = "영도구"; break;
                case 15: sigunguName = "중구"; break;
                case 16: sigunguName = "해운대구"; break;

            }break;
            case 7: switch(scode){
                case 1: sigunguName = "중구"; break;
                case 2: sigunguName = "남구"; break;
                case 3: sigunguName = "동구"; break;
                case 4: sigunguName = "북구"; break;
                case 5: sigunguName = "울주군"; break;

            }break;
            case 8: switch(scode){
                case 1: sigunguName = "세종특별시"; break;

            }break;
            case 31: switch(scode){
                case 1: sigunguName = "가평군"; break;
                case 2: sigunguName = "고양시"; break;
                case 3: sigunguName = "과천시"; break;
                case 4: sigunguName = "광명시"; break;
                case 5: sigunguName = "광주시"; break;
                case 6: sigunguName = "구리시"; break;
                case 7: sigunguName = "군포시"; break;
                case 8: sigunguName = "김포시"; break;
                case 9: sigunguName = "남양주시"; break;
                case 10: sigunguName = "동두천시"; break;
                case 11: sigunguName = "부천시"; break;
                case 12: sigunguName = "성남시"; break;
                case 13: sigunguName = "수원시"; break;
                case 14: sigunguName = "시흥시"; break;
                case 15: sigunguName = "안산시"; break;
                case 16: sigunguName = "안성시"; break;
                case 17: sigunguName = "안양시"; break;
                case 18: sigunguName = "양주시"; break;
                case 19: sigunguName = "양평군"; break;
                case 20: sigunguName = "여주시"; break;
                case 21: sigunguName = "연천군"; break;
                case 22: sigunguName = "오산시"; break;
                case 23: sigunguName = "용인시"; break;
                case 24: sigunguName = "의왕시"; break;
                case 25: sigunguName = "의정부시"; break;
                case 26: sigunguName = "이천시"; break;
                case 27: sigunguName = "파주시"; break;
                case 28: sigunguName = "평택시"; break;
                case 29: sigunguName = "포천시"; break;
                case 30: sigunguName = "하남시"; break;
                case 31: sigunguName = "화성시"; break;


            }break;
            case 32:switch(scode){
                case 1: sigunguName = "강릉시"; break;
                case 2: sigunguName = "고성군"; break;
                case 3: sigunguName = "동해시"; break;
                case 4: sigunguName = "삼척시"; break;
                case 5: sigunguName = "속초시"; break;
                case 6: sigunguName = "양구군"; break;
                case 7: sigunguName = "양양군"; break;
                case 8: sigunguName = "영월군"; break;
                case 9: sigunguName = "원주시"; break;
                case 10: sigunguName = "인제군"; break;
                case 11: sigunguName = "정선군"; break;
                case 12: sigunguName = "철원군"; break;
                case 13: sigunguName = "춘천시"; break;
                case 14: sigunguName = "태백시"; break;
                case 15: sigunguName = "평창군"; break;
                case 16: sigunguName = "홍천군"; break;
                case 17: sigunguName = "화천군"; break;
                case 18: sigunguName = "횡성군"; break;
            }break;
            case 33:switch(scode){
                case 1: sigunguName = "괴산군"; break;
                case 2: sigunguName = "단양군"; break;
                case 3: sigunguName = "보은군"; break;
                case 4: sigunguName = "영동군"; break;
                case 5: sigunguName = "옥천군"; break;
                case 6: sigunguName = "음성군"; break;
                case 7: sigunguName = "제천시"; break;
                case 8: sigunguName = "진천군"; break;
                case 9: sigunguName = "청원군"; break;
                case 10: sigunguName = "청주시"; break;
                case 11: sigunguName = "충주시"; break;
                case 12: sigunguName = "증평군"; break;

            }break;
            case 34: switch(scode){
                case 1: sigunguName = "공주시"; break;
                case 2: sigunguName = "금산군"; break;
                case 3: sigunguName = "논산시"; break;
                case 4: sigunguName = "당진시"; break;
                case 5: sigunguName = "보령시"; break;
                case 6: sigunguName = "부여군"; break;
                case 7: sigunguName = "서산시"; break;
                case 8: sigunguName = "서천군"; break;
                case 9: sigunguName = "아산시"; break;
                case 10: sigunguName = "예산군"; break;
                case 11: sigunguName = "천안시"; break;
                case 12: sigunguName = "청양군"; break;
                case 13: sigunguName = "태안군"; break;
                case 14: sigunguName = "홍성군"; break;
                case 15: sigunguName = "계룡시"; break;

            }break;
            case 35: switch(scode){
                case 1: sigunguName = "경산시"; break;
                case 2: sigunguName = "경주시"; break;
                case 3: sigunguName = "고령군"; break;
                case 4: sigunguName = "구미시"; break;
                case 5: sigunguName = "군위군"; break;
                case 6: sigunguName = "김천시"; break;
                case 7: sigunguName = "문경시"; break;
                case 8: sigunguName = "봉화군"; break;
                case 9: sigunguName = "상주시"; break;
                case 10: sigunguName = "성주군"; break;
                case 11: sigunguName = "안동시"; break;
                case 12: sigunguName = "영덕군"; break;
                case 13: sigunguName = "영양군"; break;
                case 14: sigunguName = "영주시"; break;
                case 15: sigunguName = "영천시"; break;
                case 16: sigunguName = "예천군"; break;
                case 17: sigunguName = "울릉군"; break;
                case 18: sigunguName = "울진군"; break;
                case 19: sigunguName = "청도군"; break;
                case 20: sigunguName = "청송군"; break;
                case 21: sigunguName = "칠곡군"; break;
                case 22: sigunguName = "포항시"; break;
            }break;
            case 36: switch(scode){
                case 1: sigunguName = "거제시"; break;
                case 2: sigunguName = "거창군"; break;
                case 3: sigunguName = "고성군"; break;
                case 4: sigunguName = "김해시"; break;
                case 5: sigunguName = "남해군"; break;
                case 6: sigunguName = "마산시"; break;
                case 7: sigunguName = "밀양시"; break;
                case 8: sigunguName = "사천시"; break;
                case 9: sigunguName = "산청군"; break;
                case 10: sigunguName = "양산시"; break;
                case 11: sigunguName = "의령군"; break;
                case 12: sigunguName = "진주시"; break;
                case 13: sigunguName = "진해시"; break;
                case 14: sigunguName = "창녕군"; break;
                case 15: sigunguName = "창원시"; break;
                case 16: sigunguName = "통영시"; break;
                case 17: sigunguName = "하동군"; break;
                case 18: sigunguName = "함안군"; break;
                case 19: sigunguName = "함양군"; break;
                case 20: sigunguName = "합천군"; break;
            }break;
            case 37: switch(scode){
                case 1: sigunguName = "고창군"; break;
                case 2: sigunguName = "군산시"; break;
                case 3: sigunguName = "김제시"; break;
                case 4: sigunguName = "남원시"; break;
                case 5: sigunguName = "무주군"; break;
                case 6: sigunguName = "부안군"; break;
                case 7: sigunguName = "순창군"; break;
                case 8: sigunguName = "완주군"; break;
                case 9: sigunguName = "익산시"; break;
                case 10: sigunguName = "임실군"; break;
                case 11: sigunguName = "장수군"; break;
                case 12: sigunguName = "전주시"; break;
                case 13: sigunguName = "정읍시"; break;
                case 14: sigunguName = "진안군"; break;
            }break;
            case 38: switch(scode){
                case 1: sigunguName = "강진군"; break;
                case 2: sigunguName = "고흥군"; break;
                case 3: sigunguName = "곡성군"; break;
                case 4: sigunguName = "광양시"; break;
                case 5: sigunguName = "구례군"; break;
                case 6: sigunguName = "나주시"; break;
                case 7: sigunguName = "담양군"; break;
                case 8: sigunguName = "목포시"; break;
                case 9: sigunguName = "무안군"; break;
                case 10: sigunguName = "보성군"; break;
                case 11: sigunguName = "순천시"; break;
                case 12: sigunguName = "신안군"; break;
                case 13: sigunguName = "여수시"; break;
                case 14: sigunguName = "영광군"; break;
                case 15: sigunguName = "영암군"; break;
                case 16: sigunguName = "장흥군"; break;
                case 17: sigunguName = "진도군"; break;
                case 18: sigunguName = "함평군"; break;
                case 19: sigunguName = "해남군"; break;
                case 20: sigunguName = "화순군"; break;
            }break;
            case 39:switch(scode){
                case 1: sigunguName = "남제주군"; break;
                case 2: sigunguName = "북제주군"; break;
                case 3: sigunguName = "서귀포시"; break;
                case 4: sigunguName = "제주시"; break;

            }break;
            default: break;
        }

        return sigunguName;
    }
}
