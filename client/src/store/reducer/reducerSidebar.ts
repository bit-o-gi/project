import { createSlice } from '@reduxjs/toolkit';

interface SidebarState {
    isOpen: boolean;
}

const initialState: SidebarState = {
    isOpen: false,
};

const sidebar = createSlice({
    name: 'sidebar',
    initialState,
    reducers: {
        toggleSidebar: (state) => {
            state.isOpen = !state.isOpen;
        },
    },
});

export const { toggleSidebar } = sidebar.actions;
export default sidebar.reducer;