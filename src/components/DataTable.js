import React, {useState, useEffect} from 'react'
import { DataGrid } from '@mui/x-data-grid'
import { makeStyles } from '@material-ui/styles';
import { lightBlue } from '@material-ui/core/colors';
import Button from '@material-ui/core/Button';


function getLocation(params) {
    return `(${params.getValue(params.id, 'lat') || ''}, ${
      params.getValue(params.id, 'lng') || ''
    })`;
  }


const columns = [
    {field: 'id', headerName: 'VehicleID', width: 175, headerClassName: 'app-header'},
    {field: 'type', headerName: 'Type', width: 140, headerClassName: 'app-header'},
    {field: 'qr_code', headerName: 'QR Code', width: 165, headerClassName: 'app-header'},
    {field: 'status', headerName: 'Status', width: 150, headerClassName: 'app-header'},
    {field: 'lat', headerName: 'Lat', width: 150, headerClassName: 'app-header', hide: true},
    {field: 'lng', headerName: 'Lng', width: 150, headerClassName: 'app-header', hide: true},
    {
        field: 'location',
        headerName: 'Location',
        width: 200,
        headerClassName: 'app-header',
        valueGetter: getLocation, 
        sortComparator: (v1, v2, cellParams1, cellParams2) =>
            getLocation(cellParams1).localeCompare(getLocation(cellParams2))
    },
    {
        field: 'battery_level', 
        headerName: 'Battery Level', 
        width: 200, 
        headerClassName: 'app-header',
        valueFormatter: (params) => {
            const valueFormatted = Number(params.value * 100).toLocaleString();
            return `${valueFormatted} %`;
          },
    },
    {
      field: 'operations',
      headerName: 'Operations',
      width: 235, 
      headerClassName: 'app-header',
      renderCell: (params) => (
        <strong>
          <Button
            variant="contained"
            color="primary"
            size="small"
            style={{ marginRight: 5 }}
          >
            Edit
          </Button>
          <Button
            variant="contained"
            color="Secondary"
            size="small"
          >
            Order
          </Button>
        </strong>
      ),
    }

]

const useStyles = makeStyles({
    root: {
      '& .app-header': {
        backgroundColor: '#ffa561',
      },
    },
  });
  

function DataTable() {


    const classes = useStyles();

    const [ tableData, setTableData ] = useState([]);

    const [pageSize, setPageSize] = React.useState(5);

    useEffect(() => {
        fetch("http://localhost:8080/api/vehicle")
        .then((data) => data.json())
        .then((data) => setTableData(data))
    })

    return (
        
        <div style={{height: 500, width: '65.1%',  boxShadow: '0 0 5px 0 #03989E', marginTop: '20px'}} className={classes.root}>
            <p style={{marginLeft: '30px', marginTop: '10px', fontSize: '16'}}>Vehicle List</p>
            <div style={{height:400, width: '95%',  boxShadow: '0 0 5px 0 #03989E', marginLeft: '30px', marginTop: '20px'}}>
            <DataGrid
            rows={tableData}
            columns={columns}
            pageSize={pageSize}
            onPageSizeChange={(newPageSize) => setPageSize(newPageSize)}
            rowsPerPageOptions={[5, 10, 20]}
            pagination
            />
            </div>
        </div>
    )
}

export default DataTable
