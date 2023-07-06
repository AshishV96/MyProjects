import React from 'react';
import { Card, CardBody, CardHeader, Col, Container, Row } from "reactstrap";
import StudentTable from './StudentTable';

function Dashboard() {
    return (
        <div className='col-sm-10 offset-sm-1'>
            <Container >
                <Row className="mt-4 mb-4">
                    <Col >
                        <Card>
                            <CardHeader>
                                <h2 className="text-center">Kinara_Capital Student Details</h2>
                            </CardHeader>
                            <CardBody>
                                <div>
                                    <StudentTable />
                                </div>
                            </CardBody>
                        </Card>
                    </Col>
                </Row>
            </Container>
        </div>
    );
}

export default Dashboard;
