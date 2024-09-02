import React from 'react';
import kakaoLoginImage from '../assets/images/kakao_login.png';
import axios from "axios";
import tw from "tailwind-styled-components";


function Login() {
    const handleKakaoLoginBtn = () => {
        axios.get('http://localhost:8080/oauth/kakao').then((res) => {
            window.location.href = res.data;
        }).catch((err) => {
            console.log(err);
        });
    }

    return (
        <Container>
            <Content>
                <Title>Welcome, Login!</Title>
                <ImgButton src={kakaoLoginImage} alt="kakaoLogin" onClick={handleKakaoLoginBtn}/>
            </Content>
        </Container>);
}


const ImgButton = tw.img`
    cursor-pointer
    items-center
    justify-center
    mx-auto
`;

const Container = tw.div`
    flex
    items-center
    justify-center
    min-h-screen
    bg-gray-100
`;

const Content = tw.div`
    text-center
    bg-white
    p-8
    rounded-lg
    shadow-lg
`;

const Title = tw.h2`
    text-2xl
    font-bold
    mb-4
`;

export default Login;