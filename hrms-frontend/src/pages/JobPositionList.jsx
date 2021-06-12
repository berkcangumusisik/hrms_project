import React, { useEffect, useState } from 'react'
import { Table } from 'semantic-ui-react'
import JobPositionService from '../services/JobPositionService'

export default function JobPositionList() {
    const [jobPositions, setJobPosition] = useState([])

    useEffect(() => {
    let jobPositionService = new JobPositionService()
    jobPositionService.getJobPosition().then(result => setJobPosition(result.data.data))},[])
    return (
        <div>
            <Table singleLine>
                <Table.Header>
                    <Table.Row>
                        <Table.HeaderCell>Pozisyon Numarası </Table.HeaderCell>
                        <Table.HeaderCell>Pozisyon Adı</Table.HeaderCell>

                    </Table.Row>
                </Table.Header>

                <Table.Body>
                    {
                        jobPositions.map(jobPosition => (
                            <Table.Row key={jobPosition.jobPositionId}>
                                <Table.Cell>{jobPosition.jobPositionId}</Table.Cell>
                                <Table.Cell>{jobPosition.jobPositionName}</Table.Cell>
                            </Table.Row>
                        ))
                    }

                </Table.Body>
            </Table>
        </div>

    )
}
