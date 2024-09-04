import React, {useEffect} from "react";
import styled from "styled-components";
import Sidebar from "../components/Sidebar";
import {useDispatch} from 'react-redux';
import {setAccessToken} from "../store/reducer/reducerUser";
import tw from "tailwind-styled-components";

const Main = () => {

    return (
        <MainContainer>
            <Sidebar/>
            <Content>
                <Section>
                    <Title>시작한지</Title>
                    <Countdown>100일</Countdown>
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