import React, {useEffect} from "react";
import styled from "styled-components";
import Sidebar from "../components/Sidebar";
import {useDispatch, useSelector} from 'react-redux';
import {RootState} from '../store';
import axios from "axios";
import {useLocation, useNavigate} from "react-router-dom";
import {setAccessToken} from "../store/reducer/reducerUser";
import tw from "tailwind-styled-components";

const Main = () => {
    const location = useLocation();
    const dispatch = useDispatch();
    const queryParams = new URLSearchParams(location.search);
    const navigate = useNavigate();

    useEffect(() => {
        if (queryParams?.get("code")) {
            const params = new URLSearchParams;
            params.append('code', queryParams.get("code") || "");
            navigate('/');

            axios.post('http://localhost:8080/oauth/kakao/token', params)
                .then((res) => {
                    dispatch(setAccessToken(res.data));
                    handleGetUserInfo(res.data);
                })
                .catch((err) => {
                    console.log(err);
                })
        }
    }, []);

    const handleGetUserInfo = (accessToken: string) => {
        axios.post('http://localhost:8080/oauth/kakao/access', accessToken,
            {
                headers: {
                    'Content-Type': 'application/json',
                }
            })
            .then((res) => {
                console.log(res);
            })
            .catch((err) => {
                console.log(err);
            })
    }

    return (
        <MainContainer>
            <Sidebar/>
            <Content>
                <Section>
                    <Title>우리의 디데이</Title>
                    <Countdown>D-100</Countdown>
                </Section>
            </Content>
        </MainContainer>
    );
};

const MainContainer = styled.div`
    display: flex;
    flex-direction: column;
    background-color: #f0f4f8;
    min-height: 100vh;
`;

const Content = styled.div`
    flex: 1;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    padding: 20px;
`;

const Title = tw.h1`
    text-4xl
    font-bold
    p-4
`;

const Section = tw.section`
    mt-8
    p-8
    bg-white
    rounded-lg
    shadow-lg
    text-center
    max-w-md
    w-full
`;

const Countdown = tw.h3`
    text-2xl
    font-semibold
    text-pink-500
`;

export default Main;