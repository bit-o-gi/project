import {createSlice, PayloadAction} from '@reduxjs/toolkit';
import {RootState} from '../index';

interface UserState {
    accessToken: string;
}

const initialState: UserState = {
    accessToken: '',
};

const user = createSlice({
    name: 'user',
    initialState,
    reducers: {
        setAccessToken: (state, action: PayloadAction<string>) => {
            state.accessToken = action.payload;
        },
    },
});

export const {setAccessToken} = user.actions;
export const getAccessToken = (state: RootState) => state.user.accessToken;
export default user.reducer;