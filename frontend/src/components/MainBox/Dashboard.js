import "./index.css"
import { Box, Paper, Grid } from "@material-ui/core"
import { makeStyles } from '@material-ui/core/styles';
import Pagination from '@material-ui/lab/Pagination';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import axios from "axios"
import { baseUrl, endpoints } from "../../helpers/urls"
import React, { useEffect, useState } from "react"


export default function Dashboard() {
    const classes = useStyles();
    const [page, setPage] = useState(1);
    const [data, setData] = useState([])
    const [pagelimit, setpagelimit] = useState(1);
    const pageSize = 5;

    const handleChange = async (event, value) => {
        setPage(value)
        fetchPage(value)
    };

    useEffect(() => {
        fetchPage(page)
        fetchPageLimit()
    }, [])


    const fetchPage = async (value) => {
        try {
            const url = baseUrl.backend + endpoints.vehicle + "?page=" + value
            const response = await axios.get(url)
            setData(response.data)
        }
        catch (error) {
            console.log("Network Error")
        }
    }

    const fetchPageLimit = async () => {
        try {
            const url = baseUrl.backend + endpoints.vehicleSize
            const response = await axios.get(url)
            const value = (response.data - response.data % pageSize) / pageSize
            setpagelimit(value + 1);
        }
        catch (error) {
            console.log("Network Error")
        }
    }

    const dataControl = () => {
        if (!data[0]) {
            return (
                <TableRow>
                    Network Error
                </TableRow>
            )
        }
        return (
            data.map((row) => (
                <TableRow key={row.id}>
                    <TableCell component="th" scope="row">
                        {row.id}
                    </TableCell>
                    <TableCell align="right">{row.qr_code}</TableCell>
                    <TableCell align="right">{row.type}</TableCell>
                    <TableCell align="right">{row.status}</TableCell>
                    <TableCell align="right">{row.lat}</TableCell>
                    <TableCell align="right">{row.lng}</TableCell>
                    <TableCell align="right">{row.battery_level}</TableCell>
                </TableRow>
            ))
        )
    }

    return (<>
        <div style={{}}>
            <Grid style={{ display: "flex", justifyContent: "center", }}>
                <TableContainer className={classes.table} component={Paper}>
                    <Table aria-label="simple table">
                        <TableHead>
                            <TableRow>
                                <TableCell>id</TableCell>
                                <TableCell align="right">QR CODE</TableCell>
                                <TableCell align="right">TYPE</TableCell>
                                <TableCell align="right">STATUS</TableCell>
                                <TableCell align="right">LAT</TableCell>
                                <TableCell align="right">LNG</TableCell>
                                <TableCell align="right">BATTERY Level</TableCell>

                            </TableRow>
                        </TableHead>
                        <TableBody>
                            {dataControl()}
                        </TableBody>
                    </Table>
                </TableContainer>
            </Grid>
            <div style={{
                display: "flex",
                justifyContent: "center",
                marginTop: "auto",
                alignSelf: "flex-end"
            }}>
                <Box className={classes.root}>
                    <Pagination count={pagelimit} page={page} onChange={handleChange} />
                </Box>
            </div>
        </div >
    </>)
}

const useStyles = makeStyles((theme) => ({
    root: {
        position: "absolute",
        top: "500px",
    },
    table: {
        marginTop: "50px",
        maxWidth: "80%",
    }
}));