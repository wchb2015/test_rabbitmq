package com.ele.rabbitmq.dto;

public class MessageDTO {

    private Long knight_id;

    private String team_id;

    private String team_name;

    private String org_name;

    /**
     * 1.入职 2.离职
     */
    private Integer operation_type;

    public Long getKnight_id() {
        return knight_id;
    }

    public void setKnight_id(Long knight_id) {
        this.knight_id = knight_id;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getOrg_name() {
        return org_name;
    }

    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }

    public Integer getOperation_type() {
        return operation_type;
    }

    public void setOperation_type(Integer operation_type) {
        this.operation_type = operation_type;
    }

    @Override
    public String toString() {
        return "MessageDTO{" +
                "knight_id=" + knight_id +
                ", team_id='" + team_id + '\'' +
                ", team_name='" + team_name + '\'' +
                ", org_name='" + org_name + '\'' +
                ", operation_type=" + operation_type +
                '}';
    }
}
