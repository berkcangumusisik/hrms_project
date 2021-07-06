import React from 'react'
import { NavLink } from 'react-router-dom'
import { Button, Dropdown, Menu } from 'semantic-ui-react'
export default function Logout({ logIn }) {
    return (
        <div>
            <Menu.Item>
                <Button style={{ backgroundColor: "red", color: "white", marginBottom: "0.001em" }}>
                    <Dropdown pointing="top right" text="Kayıt Ol">
                        <Dropdown.Menu >
                            <Dropdown.Item as={NavLink} to="/employerRegister" text="İş Veren" icon="angle double right" />
                            <Dropdown.Item as={NavLink} to="/jobSeekerRegister" text="İş Arayan" icon="angle double right" />
                        </Dropdown.Menu>
                    </Dropdown>
                </Button>
                <Button onClick={logIn} style={{ backgroundColor: "red", color: "white", marginLeft: "0.5em", marginBottom: "0.001em" }} >Giriş Yap</Button>
            </Menu.Item>
            
        </div>
    )
}