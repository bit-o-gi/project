import React from "react";
import styled from "styled-components";
import { Link } from "react-router-dom";
import { useSelector, useDispatch } from 'react-redux';
import { RootState } from '../store';
import { toggleSidebar } from '../store/reducer/reducerSidebar';

const Sidebar = () => {
    const isSidebarOpen = useSelector((state: RootState) => state.sidebar.isOpen);
    const dispatch = useDispatch();

    return (
        <>
            {isSidebarOpen && (
                <SidebarContainer>
                    <NavItem to="/">Home</NavItem>
                    <NavItem to="/login">Login</NavItem>
                    {/* Add more navigation items as needed */}
                </SidebarContainer>
            )}
            <ToggleButton onClick={() => dispatch(toggleSidebar())}>
                {isSidebarOpen ? "Close Sidebar" : "Open Sidebar"}
            </ToggleButton>
        </>
    );
};

const SidebarContainer = styled.div`
    width: 200px;
    height: 100vh;
    background-color: #f0f0f0;
    display: flex;
    flex-direction: column;
    align-items: center;
    padding-top: 20px;
    position: fixed;
    left: 0;
    top: 0;
    transition: transform 0.3s;
`;

const NavItem = styled(Link)`
    margin: 10px 0;
    text-decoration: none;
    color: #333;
    font-size: 1.2rem;

    &:hover {
        color: #ff69b4;
    }
`;

const ToggleButton = styled.button`
    position: absolute;
    top: 20px;
    left: 20px;
    z-index: 1;
`;

export default Sidebar;