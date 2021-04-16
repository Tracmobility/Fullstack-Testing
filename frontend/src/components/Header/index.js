import NotificationsIcon from '@material-ui/icons/Notifications';
import MailIcon from '@material-ui/icons/Mail';
import MenuItem from '@material-ui/core/MenuItem';
import Menu from '@material-ui/core/MenuList';
import { makeStyles } from '@material-ui/core/styles';

export default function Header() {
    const classes = useStyles();

    return (
        <div >
            <Menu className={classes.root} >
                <MenuItem ><MailIcon></MailIcon></MenuItem>
                <MenuItem ><NotificationsIcon></NotificationsIcon></MenuItem>
                <MenuItem >Logout</MenuItem>
            </Menu>
        </div >
    )
}

const useStyles = makeStyles((theme) => ({
    root: {
        display: 'flex',
        flexWrap: 'wrap',
        overflow: 'hidden',
        justifyContent: "flex-end"
    },
    paper: {
        marginRight: theme.spacing(2),
    },
}));