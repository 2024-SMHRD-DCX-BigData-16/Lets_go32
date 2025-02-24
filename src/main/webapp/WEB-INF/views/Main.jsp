<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
</head>
<body>
    <h1>회원가입</h1>
    <form action="register" method="post">
        <p>아이디 : <input type="text" name="userId" required></p>
        <p>비밀번호 : <input type="password" name="userPw" required></p>
        <p>이름 : <input type="text" name="userName" required></p>
        <p>메일 주소 : <input type="email" name="userEmail" required></p>
        <p>성별 : 
            <input type="radio" name="gender" value="M" required>남
            <input type="radio" name="gender" value="F">여
        </p>
        <p>여행 목적 : 
            <select name="travelPurpose" required>
                <option value="Leisure">여가</option>
                <option value="Business">비즈니스</option>
                <option value="Adventure">모험</option>
                <option value="Relaxation">휴식</option>
            </select>
        </p>
        <p>선호 분위기 : <input type="text" name="preferredMood" required></p>
        <p>선호 음식 : <input type="text" name="preferredFood" required></p>
        <button type="submit">회원가입</button>
    </form>
</body>
</html>
