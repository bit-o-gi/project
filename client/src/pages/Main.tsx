import React from "react";
import styled from "styled-components";
import Sidebar from "../components/Sidebar";
import { useSelector } from 'react-redux';
import { RootState } from '../store';

const Main = () => {
    const isSidebarOpen = useSelector((state: RootState) => state.sidebar.isOpen);

    return (
        <MainContainer>
            <Sidebar />
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
    margin-left: ${({ isSidebarOpen }) => (isSidebarOpen ? "200px" : "0")};
    transition: margin-left 0.3s;
`;

export default Main;