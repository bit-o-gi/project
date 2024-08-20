import React, {useEffect} from "react";
import styled from "styled-components";
import Sidebar from "../components/Sidebar";
import {useDispatch, useSelector} from 'react-redux';
import {RootState} from '../store';
import axios from "axios";
import {useLocation, useNavigate} from "react-router-dom";
import {setAccessToken} from "../store/reducer/reducerUser";

const Main = () => {
    const isSidebarOpen = useSelector((state: RootState) => state.sidebar.isOpen);
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
            <Content isSidebarOpen={isSidebarOpen}>
                <header className="main-header">
                    <h1>우리의 디데이</h1>
                </header>
                <section className="dday-countdown">
                    <h3>D-100</h3>
                </section>
            </Content>
        </MainContainer>
    );
};

const MainContainer = styled.div`
    display: flex;
`;

const Content = styled.div<{ isSidebarOpen: boolean }>`
    flex: 1;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    margin-left: ${({isSidebarOpen}) => (isSidebarOpen ? "200px" : "0")};
    transition: margin-left 0.3s;
`;

export default Main;