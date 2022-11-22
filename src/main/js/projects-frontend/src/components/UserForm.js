import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';

export default function UserForm() {
    return (
        <Box
            component="form"
            noValidate
            autoComplete="off"
        >
            <TextField id="standard-basic" label="Name" variant="standard" margin="normal"/>
            <TextField id="standard-basic" label="Email" variant="standard" margin="normal"/>
            <TextField id="standard-basic" label="Phone number" variant="standard" margin="normal"/>
            <FormControlLabel control={<Checkbox defaultUnchecked />} label="Is a manager" />
            
        </Box>
    );
}