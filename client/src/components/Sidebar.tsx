import React from "react";
import styled from "styled-components";
import {Link} from "react-router-dom";
import {useSelector, useDispatch} from 'react-redux';
import {RootState} from '../store';
import {toggleSidebar} from '../store/reducer/reducerSidebar';
import axios from "axios";
import {getAccessToken} from '../store/reducer/reducerUser';

const Sidebar = () => {
    const isSidebarOpen = useSelector((state: RootState) => state.sidebar.isOpen);
    const dispatch = useDispatch();
    const accessToken = useSelector((state: RootState) => getAccessToken(state));

    const handleLogOut = () => {
        axios.post('https://kapi.kakao.com/v1/user/logout', {}, {
            headers: {
                'Authorization': `Bearer ${accessToken}`
            }
        })
            .then((res) => {
                console.log(res);
            })
            .catch((err) => {
                console.log(err);
            })
    };
    return (
        <>
            <ToggleButton onClick={() => dispatch(toggleSidebar())}>
                {isSidebarOpen ? "Close Sidebar" : "Open Sidebar"}
            </ToggleButton>
            {isSidebarOpen && (
                <SidebarContainer>
                    <NavItem to="/">Home</NavItem>
                    <NavItem to="/login">Login</NavItem>
                    <div onClick={() => handleLogOut()}>LogOut</div>
                    {/* Add more navigation items as needed */}
                </SidebarContainer>
            )}

        </>
    );
};

const NavItem = styled(Link)`
    margin: 15px 0;
    text-decoration: none;
    color: #444;
    font-size: 1.4rem;

    &:hover {
        color: #ff4500;
    }
`;

const SidebarContainer = styled.div`
    width: 250px;
    height: 100vh;
    background-color: #e0e0e0;
    display: flex;
    flex-direction: column;
    align-items: center;
    padding-top: 2vh;
    position: fixed;
    left: 0;
    top: 0;
    transition: transform 0.3s;
`;

const ToggleButton = styled.button`
    position: absolute;
    top: 5px;
    left: 10px;
    z-index: 2;
    background-color: #007bff;
    color: white;
    border: none;
    padding: 10px;
    cursor: pointer;

    &:hover {
        background-color: #0056b3;
    }
`;

export default Sidebar;