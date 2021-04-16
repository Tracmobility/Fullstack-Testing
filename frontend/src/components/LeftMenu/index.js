import "./index.css"
import { Box } from "@material-ui/core"
import logo from "../../logo.png"

import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import Divider from '@material-ui/core/Divider';
import ListSubheader from '@material-ui/core/ListSubheader';

export default function LeftMenu(props) {
    const classes = useStyles();

    return (
        <div className="leftmenu">

            <img style={{
                marginTop: "10px",
                marginLeft: "10px"
            }} src={logo} width="240px"></img>
            <div className={classes.list}>
                <List component="nav" aria-label="main folders">
                    <ListItem button>
                        <ListItemText onClick={() => props.onClick(1)} primary="Dashboard" />
                    </ListItem>
                </List>
                <Divider />
                <List component="nav" aria-label="secondary folders" subheader={
                    <ListSubheader component="div" id="nested-list-subheader">
                        Task Management
                 </ListSubheader>
                }>
                    <ListItem button>
                        <ListItemText onClick={() => props.onClick(2)} primary="Task Map" />
                    </ListItem>
                    <ListItem button>
                        <ListItemText onClick={() => props.onClick(3)} primary="Task List" />
                    </ListItem>
                </List>
            </div>
        </div>
    )
}

const useStyles = makeStyles((theme) => ({
    list: {
        width: "220px",
        marginTop: "30px",
        marginLeft: "20px",
        color: "white"
    },
}));
