import React, {useEffect} from "react";
import styled from "styled-components";
import Sidebar from "../components/Sidebar";
import {useSelector} from 'react-redux';
import {RootState} from '../store';
import {useLocation} from "react-router-dom";
import axios from "axios";

const Main = () => {
    const isSidebarOpen = useSelector((state: RootState) => state.sidebar.isOpen);
    const location = useLocation();
    const queryParams = new URLSearchParams(location.search);

    useEffect(() => {
        if (queryParams?.get("code")) {
            const params = new URLSearchParams;
            params.append('code', queryParams.get("code") || "");

            axios.post('http://localhost:8080/oauth/kakao/token', params)
                .then((res) => {
                    console.log(res.data);
                })
                .catch((err) => {
                    console.log(err);
                })

        }
    }, []);

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