import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';

function Login() {
    const [isPopupOpen, setIsPopupOpen] = useState(false);
    const navigate = useNavigate();

    const handleLogin = () => {
        setIsPopupOpen(true);
    }

    const closePopup = () => {
        setIsPopupOpen(false);
        navigate('/');
    }

    return (
        <div className="Login">
            <h2>Login Page</h2>
            <button onClick={handleLogin}>Login</button>
            {isPopupOpen && (
                <Popup>
                    <h3>Login Form</h3>
                    <button onClick={closePopup}>Close</button>
                    {/* 로그인 폼을 여기에 추가 */}
                </Popup>
            )}
        </div>
    );
}

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