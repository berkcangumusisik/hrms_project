import React, { useEffect, useState } from 'react'
import { Table } from 'semantic-ui-react'
import JobSeekerService from '../services/JobSeekerService'

export default function JobSeekerList() {
    const [jobSeekers, setJobSeekers] = useState([])

    useEffect(() => {
        let jobSeekersService = new JobSeekerService()
        jobSeekersService.getJobSeeker().then(result => setJobSeekers(result.data.data))},[])

    return (
        <div>
            <Table celled>
                <Table.Header>
                    <Table.Row>
                        <Table.HeaderCell>First Name</Table.HeaderCell>
                        <Table.HeaderCell>Last Name</Table.HeaderCell>
                        <Table.HeaderCell>Birth Date</Table.HeaderCell>
                        <Table.HeaderCell>E-mail address</Table.HeaderCell>
                    </Table.Row>
                </Table.Header>

                <Table.Body>
                    <Table.Row>
                    {
                        jobSeekers.map(jobSeeker => (
                            <Table.Row key={jobSeeker.id}>
                                <Table.Cell>{jobSeeker.firstName}</Table.Cell>
                                <Table.Cell>{jobSeeker.lastName}</Table.Cell>
                                <Table.Cell>{jobSeeker.birthYear}</Table.Cell>
                                <Table.Cell>{jobSeeker.email}</Table.Cell>   
                            </Table.Row>
                        ))
                    }
                    </Table.Row>
                </Table.Body>
            </Table>
        </div>
    )
}