import React, { useEffect, useState } from 'react'
import { Table } from 'semantic-ui-react'
import SystemPersonnelService from "../services/SystemPersonnelService"
export default function SystemPersonnelList() {
    const [personnels, setPersonnel] = useState([])
    useEffect(() => {
        let personnelService = new SystemPersonnelService()
        personnelService.getPersonnel().then(result => setPersonnel(result.data.data))},[])
    
    return (
    <div>
            <Table celled inverted selectable color="green">
            <Table.Header >
            <Table.Row>
                <Table.Cell> Ad</Table.Cell>
                <Table.Cell>Soyad</Table.Cell>
                <Table.Cell>Email Adresi</Table.Cell>
            </Table.Row>
            </Table.Header>

            <Table.Body>
            {
                personnels.map(personnel =>
                (
                    <Table.Row key={personnel.userId}>
                        <Table.Cell>{personnel.firstName}</Table.Cell>
                        <Table.Cell>{personnel.lastName}</Table.Cell>
                        <Table.Cell>{personnel.email}</Table.Cell>
                    </Table.Row>
                ))
            }
            </Table.Body>

        </Table>
    </div>
    )
}
