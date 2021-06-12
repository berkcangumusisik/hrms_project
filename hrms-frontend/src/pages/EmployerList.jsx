import React, { useEffect, useState } from 'react'
import { Table } from 'semantic-ui-react'
import EmployerService from '../services/EmployerService'

export default function EmployerList() {

    const [employers, setEmployer] = useState([])
    useEffect(() => {
        let employerService = new EmployerService()
        employerService.getEmployer().then(result => setEmployer(result.data.data))},[])
    


    return (
        <div>
            <Table singleLine>
                <Table.Header>
                    <Table.Row>
                        <Table.HeaderCell>Şirket Adı </Table.HeaderCell>
                        <Table.HeaderCell>Telefon Numarası</Table.HeaderCell>
                        <Table.HeaderCell>Web Sitesi</Table.HeaderCell>

                    </Table.Row>
                </Table.Header>

                <Table.Body>
                    {
                        employers.map(employer => (
                            <Table.Row key={employer.userId}>
                                <Table.Cell>{employer.companyName}</Table.Cell>
                                <Table.Cell>{employer.phoneNumber}</Table.Cell>
                                <Table.Cell>{employer.webSite}</Table.Cell>   
                            </Table.Row>
                        ))
                    }

                </Table.Body>
            </Table>
        </div>
    )
}