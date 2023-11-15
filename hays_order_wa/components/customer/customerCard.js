import React from "react";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import Typography from "@mui/material/Typography";
import Stack from "@mui/material/Stack";
import Box from "@mui/material/Box";

const CustomerCard = ({ customer , onClick }) => {
  const { name, id ,  address, email, number } = customer;

  return (
    <Card
      variant="outlined"
      onClick={onClick}
      sx={{ border: "1px solid #ccc", boxShadow: "0 0 10px #ccc" , margin: "5px"}}
    >
      <CardContent>
        <Stack spacing={2}>
          <Typography variant="h5" component="h2" sx={{ fontWeight: "bold" }}>
            {name}
          </Typography>
          <Box>
            <Typography color="textSecondary">Id: {id}</Typography>
            <Typography color="textSecondary">Address: {address}</Typography>
            <Typography color="textSecondary">Email: {email}</Typography>
            <Typography color="textSecondary">Number: {number}</Typography>
          </Box>
        </Stack>
      </CardContent>
    </Card>
  );
};

export default CustomerCard;
