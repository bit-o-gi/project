import React from "react";
import {Link} from "react-router-dom";
import {useSelector, useDispatch} from 'react-redux';
import {RootState} from '../store';
import {toggleSidebar} from '../store/reducer/reducerSidebar';

const Sidebar = () => {
    const isSidebarOpen = useSelector((state: RootState) => state.sidebar.isOpen);
    const dispatch = useDispatch();

    return (
        <>
            <button
                onClick={() => dispatch(toggleSidebar())}
                className="absolute top-1 left-2 z-10 bg-blue-500 text-white border-none p-2 cursor-pointer hover:bg-blue-700"
            >
                {isSidebarOpen ? "Close Sidebar" : "Open Sidebar"}
            </button>
            {isSidebarOpen && (
                <div
                    className="w-64 h-screen bg-gray-300 flex flex-col items-center pt-8 fixed left-0 top-0 transition-transform duration-300">
                    <Link to="/" className="my-4 text-gray-700 text-xl no-underline hover:text-orange-500">
                        Home
                    </Link>
                </div>
            )}
        </>
    );
};

export default Sidebar;