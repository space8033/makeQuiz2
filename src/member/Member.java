package member;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class Member {
    private String name;
    private String phoneNumber;
    private String registeredAt;

    public Member(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = makePhoneNumber(phoneNumber);
        this.registeredAt = makeTimeStamp();
    }

    private String makePhoneNumber(String phoneNumber) {
        //핸드폰 번호 정규 표현식 : ^01(?:0|1|[6-9]) - (?:\d{3}|\d{4}) - \d{4}$
        if(phoneNumber.length() == 11) {
            StringBuilder sb = new StringBuilder();
            sb.append(phoneNumber.substring(0, 3));
            sb.append("-");
            sb.append(phoneNumber.substring(3,7));
            sb.append("-");
            sb.append(phoneNumber.substring(7));

            return sb.toString();

        }else if(phoneNumber.length() == 10){
            StringBuilder sb = new StringBuilder();
            sb.append(phoneNumber.substring(0, 3));
            sb.append("-");
            sb.append(phoneNumber.substring(3,6));
            sb.append("-");
            sb.append(phoneNumber.substring(6));

            return sb.toString();
        }else {
            return "잘못된 전화번호 입니다";
        }
    }

    private String makeTimeStamp() {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 a HH:mm:ss");

        return sdf.format(now);
    }
}
