import React, { useEffect, useState } from "react";
import axios from "axios";
import DataTable from 'react-data-table-component';
import { Button, Card, Row, Table } from "react-bootstrap";

function StudentList()  
{
    const [data, setData] = useState([]);
    const [pgNo, setPgno] = useState(1);

    useEffect(() => {
        const fetchData = async() => {
        try {
            const response = await axios.get('student/getAll?pageNo='+(pgNo-1));
            setData(response.data);
         }
         catch (error) {
            console.error('Error fetching data:',error);
         }
    };

    fetchData();
},[pgNo]);

const columns = [
    {
        name:"ID",
        selector: 'id',
        // sortable: true
    }, 
    {
        name:"NAME",
        selector: 'name',
        // sortable: true
    },
    {
        name:"AGE",
        selector: 'age',
        sortable: true
    },
    {
        name:"BRANCH",
        selector: 'branch',
        sortable: true
    }, 
    {
        name:"PASSOUT_YEAR",
        selector: 'passoutYear',
        sortable: true
    }, 
    {
        name:"CITY",
        selector: 'city',
        sortable: true
    },
    {
        name:"STATE",
        selector: 'state',
        sortable: true
    },
    {
        name:"EXPERIENCE",
        selector: 'experience',
        sortable: true
    },
  ];

  const count = ()=> console.log(pgNo);

return (
 <div><h3 className="mt-5 mb-5">Student Table</h3>
    <Table striped border={5}>
        <thead>
            <tr>
                <th>S.no</th>
                <th>Name</th>
                <th>Age</th>
                <th>Gender</th>
                <th>Branch</th>
                <th>Passout Year</th>
                <th>City</th>
                <th>State</th>
                <th>Experience</th>
            </tr>
        </thead>
        <tbody>
        {
            data.map((item) =>
            <tr>
                <td>{item.id}</td>
                <td>{item.name}</td>
                <td>{item.age}</td>
                <td>{(item.gender==='m'||item.gender==='M')?'Male':'Female'}</td>
                <td>{item.branch}</td>
                <td>{item.passoutYear}</td>
                <td>{item.city}</td>
                <td>{item.state}</td>
                <td>{item.experience}</td>
            </tr>
            )
        }
        </tbody>
    </Table>

<footer>
    <div>
    <Button className="me-1" onClick={()=>{if(pgNo>1)setPgno(pgNo-1)}}>prev</Button>
    <Button className="me-1" onClick={()=>{setPgno(1)}}>1</Button>
    <Button className="me-1" onClick={()=>{setPgno(2)}}>2</Button>
    <Button className="me-1" onClick={()=>{setPgno(3)}}>3</Button>
    <Button className="me-1" onClick={()=>{setPgno(4)}}>4</Button>
    <Button className="me-1" onClick={()=>{setPgno(5)}}>5</Button>
    <Button className="me-1" onClick={()=>{setPgno(6)}}>6</Button>
    <Button className="me-1" onClick={()=>{setPgno(7)}}>7</Button>
    <Button className="me-1" onClick={()=>{setPgno(8)}}>8</Button>
    <Button className="me-1" onClick={()=>{if(pgNo<8)setPgno(pgNo+1)}}>next</Button>
    </div>
</footer>
</div>

); 
}

export default StudentList;