import React, { useEffect, useState } from 'react';
import DataTable from 'react-data-table-component';
import axios from 'axios';
import { Button, Dropdown, DropdownItem, DropdownMenu, DropdownToggle, Input, Label } from 'reactstrap';
import { ToastContainer, toast } from 'react-toastify';

function StudentTable() {

  const [students, setStudents] = useState([]);
  const [currentPage, setCurrentPage] = useState(1);
  const [perPage, setPerPage] = useState(10);
  const [totalPages, setTotalPages] = useState(9);
  const [searchQuery, setSearchQuery] = useState('');
  const [dropdownOpen, setDropdownOpen] = useState('');
  const [filterAttribute, setFilterAttribute] = useState('');

  useEffect(() => {
    //fetchStudents();
    handleFilterSubmit();
  }, [currentPage]);

  const handleFilterSubmit = async () => {
    if (searchQuery !== "") {
      try {
        const response = await axios.get(`http://localhost:7777/api/${filterAttribute}/${searchQuery}`, {
          params: {
            pageNumber: currentPage - 1,
            // pageSize: perPage
          }
        });
        setStudents(response.data);
        toast.success("success");
        //setTotalPages(response.data);
      } catch (error) {
        // alert("invalid input")
        toast.error("invalid input");
        console.error(`Error fetching students by ${filterAttribute}:`, error);
      }
    } else {
      fetchStudents();
    }
  };

  const fetchStudents = async () => {
    try {
      const response = await axios.get('http://localhost:7777/api/details', {
        params: {
          pageNumber: currentPage - 1,
          pageSize: perPage
        }
      });
      setStudents(response.data);
      //setTotalPages(response.data);
    } catch (error) {
      console.error('Error fetching students:', error);
    }
  };

  const handlePageChange = (page) => {
    console.log(page);
    setCurrentPage(page);
  };

  const handleSearch = event => {
    setSearchQuery(event.target.value);
    setCurrentPage(1);
  };

  const handleRowsPerPageChange = (currentRowsPerPage, currentPage) => {
    setPerPage(currentRowsPerPage);
    setCurrentPage(1);
  };

  const handleFilterChange = (attribute) => {
    setFilterAttribute(attribute);
    setSearchQuery('');
    setCurrentPage(1);
  };

  const handleDropdownToggle = () => {
    setDropdownOpen(!dropdownOpen)
  }

  const columns = [
    {
      name: 'ID',
      selector: 'id',
      sortable: true
    },
    {
      name: 'NAME',
      selector: 'name',
      sortable: true
    },
    {
      name: 'AGE',
      selector: 'age',
      sortable: true
    },
    {
      name: 'BRANCH',
      selector: 'branch',
      sortable: true
    },
    {
      name: 'PASSOUT_YEAR',
      selector: 'passOutYear',
      sortable: true
    },
    {
      name: 'CITY',
      selector: 'city',
      sortable: true
    },
    {
      name: 'STATE',
      selector: 'state',
      sortable: true
    },
    {
      name: 'EXPERIENCE',
      selector: 'experience',
      sortable: true
    },
    {
      name: 'GENDER',
      selector: 'gender',
      sortable: true
    }
  ];

  return (
    <div>
      <Dropdown isOpen={dropdownOpen} toggle={handleDropdownToggle}>
        <DropdownToggle caret>Filter By</DropdownToggle>
        <DropdownMenu>
          <DropdownItem onClick={() => handleFilterChange('city')}>City</DropdownItem>
          <DropdownItem onClick={() => handleFilterChange('branch')}>Branch</DropdownItem>
          <DropdownItem onClick={() => handleFilterChange('age')}>Age</DropdownItem>
          <DropdownItem onClick={() => handleFilterChange('experience')}>Experience</DropdownItem>
          <DropdownItem onClick={() => handleFilterChange('passoutYear')}>Passout Year</DropdownItem>
          <DropdownItem onClick={() => handleFilterChange('gender')}>Gender</DropdownItem>
        </DropdownMenu>
      </Dropdown>
      <Input
        type='text'
        placeholder='search here'
        value={searchQuery}
        onChange={handleSearch}
      />
      <Button onClick={handleFilterSubmit}>Apply Filter</Button>

      <DataTable
        title=""
        columns={columns}
        data={students}
        pagination
        paginationServer
        paginationTotalRows={totalPages * perPage}
        paginationPerPage={perPage}
        paginationComponentOptions={{
          noRowsPerPage: true
        }}
        // paginationRowsPerPageOptions={[10, 15, 20, 25]}
        onChangePage={handlePageChange}
        onChangeRowsPerPage={handleRowsPerPageChange}
        paginationActivePage={currentPage}
      />
      <ToastContainer />
    </div>
  );
}

export default StudentTable;









