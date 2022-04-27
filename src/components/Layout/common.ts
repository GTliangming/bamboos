import styled from "styled-components";
export const Nav = styled.nav`
    width: 100vw;
    position: fixed;
    top: 0;
    z-index: 9;
    box-shadow: 0 0 18px #000;
    transition: all .3s;
background-color: rgba(35, 35, 44, 1);
`;

export const NavContent = styled.div`
    display: flex;
    justify-content: center;
    align-items: center;
    position: relative;
    width: 1200px;
    height: 60px;
    padding: 9px 0;
    margin: 0 auto;
`;
export const NavItem = styled.div`
    height: 44px;
    width: 70px;
    font-size: 20px;
    margin-right: 20px;
    border-radius: 14px;
    color: #fff;
    transition: all .2s;
    -webkit-user-select: none;
    -ms-user-select: none;
    user-select: none;
    display: flex;
    justify-content: center;
    align-items: center;
    &:hover,&::selection{
        background: #1890ff;
    }
    &>a{
        color: #fff;
    }
`;

export const Footer = styled.footer`
    width: 100vw;
    text-align: center;
`;
