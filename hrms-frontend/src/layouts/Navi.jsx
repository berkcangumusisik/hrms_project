import React from "react";
import { Button, Icon, Menu,Image,Container } from "semantic-ui-react";
import  img  from "../images/logo.png";
export default function Navi() {
  return (
    <div>
      <Menu color="purple" inverted fixed="top" size="large" >
      <Image src={img} className="photo"/>
      <h4 className="nav-title"><b>H</b>uman  <b>R</b>esource <br/> <b>M</b>anagment  <b>S</b>ystem </h4>
        <Container>
          <Menu.Item> <Icon name="home"/>Ana Sayfa</Menu.Item>
          <Menu.Item > <Icon name="certificate"/> İş İlanları</Menu.Item>
          <Menu.Item > <Icon name="edit outline"/> Cv Oluştur</Menu.Item>
          <Menu.Item > <Icon name="edit outline"/> Kariyer Rehberi</Menu.Item>
          <Menu.Menu position="right">
            <Menu.Item>
              <Button.Group>
                <Button primary>Giriş Yap</Button>
                <Button.Or />
                <Button positive>Üye Ol</Button>
              </Button.Group>
              <Menu.Item > <Icon name="help"/> Yardım</Menu.Item>
            </Menu.Item>
          </Menu.Menu>
        </Container>
      </Menu>
      </div>
  );
}