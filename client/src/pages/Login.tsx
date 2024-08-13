import React, {useState} from 'react';
import {useNavigate} from 'react-router-dom';
import styled from 'styled-components';
import kakaoLoginImage from '../assets/images/kakao_login.png';
import axios from "axios";

function Login() {
    const [isPopupOpen, setIsPopupOpen] = useState(false);
    const navigate = useNavigate();

    const handleLogin = () => {
        setIsPopupOpen(true);
    }

    const handleKakaoLoginBtn = () => {
        axios.get('http://localhost:8080/oauth/kakao').then((res) => {
            window.location.href = res.data;
        }).catch((err) => {
            console.log(err);
        });
    }

    const closePopup = () => {
        setIsPopupOpen(false);
        navigate('/');
    }

    return (
        <div className="Login">
            <h2>Login</h2>
            <ImgButton src={kakaoLoginImage} alt="kakaoLogin" onClick={handleKakaoLoginBtn}/>
            {isPopupOpen && (
                <Popup>
                    <h3>Login</h3>
                    <button onClick={closePopup}>Close</button>
                </Popup>
            )}
        </div>
    );
}

const ImgButton = styled.img`
    cursor: pointer;
`;

const Popup = styled.div`
    position: fixed;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    background-color: white;
    padding: 20px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    z-index: 1000;
`;

export default Login;