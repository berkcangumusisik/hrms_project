import React, { useEffect, useState } from 'react'
import { Table } from 'semantic-ui-react'
import PhotographService from '../services/PhotographService'

export default function PhotographList() {
    const [photographs, setPhotographs] = useState([])

    useEffect(() => {
        let photographsService = new PhotographService()
        photographsService.getPhotographs().then(result => setPhotographs(result.data.data))},[])

    return (
        <div>
            <Table singleLine>
                <Table.Header>
                    <Table.Row>
                        <Table.HeaderCell>Fotoğraf Id</Table.HeaderCell>
                        <Table.HeaderCell>Fotoğraf Url</Table.HeaderCell>

                    </Table.Row>
                </Table.Header>

                <Table.Body>
                    {
                        photographs.map(photographs => (
                            <Table.Row key={photographs.photographId}>
                                <Table.Cell>{photographs.photographId}</Table.Cell>
                                <Table.Cell>{photographs.photographLink}</Table.Cell>

                            </Table.Row>
                        ))
                    }

                </Table.Body>
            </Table>

        </div>
    )
}

