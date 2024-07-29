import React from 'react';
import {useNavigate} from 'react-router-dom';

function Login() {
    const navigate = useNavigate();

    const handleLogin = () => {
        navigate('/');
    }


    return (
        <div className="Login">
            <h2>Login Page</h2>
            <button onClick={handleLogin}>Button</button>
            {/* 로그인 폼을 여기에 추가 */}
        </div>
    );
}

export default Login;